/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.impl;

import com.github.jofernando.projeto.tcc.model.dao.interfaces.PedidoDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Pedido;
import com.github.jofernando.projeto.tcc.util.JpaUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

/**
 *
 * @author Fernando
 */
public class BancoDeDadosPedidoDAO implements PedidoDAO {

    @Override
    public boolean estaCadastrado(Pedido t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    List<Pedido> pedidos = manager.createQuery("from Pedido p where p.cliente.id = :cliente_id"
		    + " and p.campanha = :campanha")
		    .setParameter("campanha", t.getCampanha())
		    .setParameter("cliente_id", t.getCliente().getId())
		    .getResultList();
	    if (t.getId() != 0 && pedidos.size() == 1 && pedidos.get(0).getId() == (t.getId())) {
		return false;
	    }
	    return !pedidos.isEmpty();
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return false;
	} finally {
	    manager.close();
	}
    }

    @Override
    public void inserir(Pedido t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.persist(t);
	    manager.getTransaction().commit();
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Pedido cadastrado", null));
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	} finally {
	    manager.close();
	}
    }

    @Override
    public void alterar(Pedido t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.merge(t);
	    manager.getTransaction().commit();
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Pedido alterado", null));
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	} finally {
	    manager.close();
	}
    }

    @Override
    public void deletar(Pedido t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.remove(manager.merge(t));
	    manager.getTransaction().commit();
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Pedido deletado", null));
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	} finally {
	    manager.close();
	}
    }

    @Override
    public Pedido buscar(int id) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return (Pedido) manager.find(Pedido.class, id);
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return null;
	} finally {
	    manager.close();
	}
    }

    @Override
    public List<Pedido> buscarTodos() {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return manager.createQuery("from Pedido p").getResultList();
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return null;
	} finally {
	    manager.close();
	}
    }

}
