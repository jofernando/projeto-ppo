/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.impl;

import com.github.jofernando.projeto.tcc.model.dao.interfaces.ClienteDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Cliente;
import com.github.jofernando.projeto.tcc.util.JpaUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.hibernate.HibernateException;

/**
 *
 * @author Fernando
 */
public class BancoDeDadosClienteDAO implements ClienteDAO {

    @Override
    public Cliente buscarPorCpf(String cpf) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return (Cliente) manager.createQuery("from Cliente c where c.cpf = :cpf")
		    .setParameter("cpf", cpf)
		    .getSingleResult();
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return null;
	} finally {
	    manager.close();
	}
    }

    @Override
    public boolean estaCadastrado(Cliente t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    List<Cliente> clientes = manager.createQuery("from Cliente c where c.cpf = :cpf")
		    .setParameter("cpf", t.getCpf())
		    .getResultList();
	    if (t.getId() != 0 && clientes.size() == 1 && clientes.get(0).getId() == (t.getId())) {
		return false;
	    }
	    return !clientes.isEmpty();
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return false;
	} finally {
	    manager.close();
	}
    }

    @Override
    public void inserir(Cliente t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.persist(t);
	    manager.getTransaction().commit();
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Cliente cadastrado", null));
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	} finally {
	    manager.close();
	}
    }

    @Override
    public void alterar(Cliente t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.merge(t);
	    manager.getTransaction().commit();
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Cliente alterado", null));
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	} finally {
	    manager.close();
	}
    }

    @Override
    public void deletar(Cliente t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.createQuery("delete from Pedido p where p.cliente.id = :cliente_id")
		    .setParameter("cliente_id", t.getId())
		    .executeUpdate();
	    manager.remove(manager.merge(t));
	    manager.getTransaction().commit();
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Cliente deletado", null));
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	} finally {
	    manager.close();
	}
    }

    @Override
    public Cliente buscar(int id) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return (Cliente) manager.find(Cliente.class, id);
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return null;
	} finally {
	    manager.close();
	}
    }

    @Override
    public List<Cliente> buscarTodos() {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return manager.createQuery("from Cliente c").getResultList();
	} catch (HibernateException e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return null;
	} finally {
	    manager.close();
	}
    }
}
