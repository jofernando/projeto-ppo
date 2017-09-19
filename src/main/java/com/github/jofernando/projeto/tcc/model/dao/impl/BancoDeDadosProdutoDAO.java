/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.impl;

import com.github.jofernando.projeto.tcc.model.dao.interfaces.ProdutoDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Produto;
import com.github.jofernando.projeto.tcc.util.JpaUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

/**
 *
 * @author Fernando
 */
public class BancoDeDadosProdutoDAO implements ProdutoDAO {

    @Override
    public Produto buscarPorCodigo(String codigo) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return (Produto) manager.createQuery("from Produto p where p.codigo = :codigo")
		    .setParameter("codigo", codigo)
		    .getSingleResult();
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return null;
	} finally {
	    manager.close();
	}
    }

    @Override
    public boolean estaCadastrado(Produto t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    List<Produto> produtos = manager.createQuery("from Produto p where p.codigo = :codigo")
		    .setParameter("codigo", t.getCodigo())
		    .getResultList();
	    if (t.getId() != 0 && produtos.size() == 1 && produtos.get(0).getId() == t.getId()) {
		return false;
	    }
	    return !produtos.isEmpty();
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return false;
	} finally {
	    manager.close();
	}
    }

    @Override
    public void inserir(Produto t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.persist(t);
	    manager.getTransaction().commit();
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Produto cadastrado", null));
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	} finally {
	    manager.close();
	}
    }

    @Override
    public void alterar(Produto t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.merge(t);
	    manager.getTransaction().commit();
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Produto alterado", null));
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	} finally {
	    manager.close();
	}
    }

    @Override
    public void deletar(Produto t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.createQuery("delete from ItemPedido i where i.produto.id = :produto_id")
		    .setParameter("produto_id", t.getId())
		    .executeUpdate();
	    manager.remove(manager.merge(t));
	    manager.getTransaction().commit();
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! Produto deletado", null));
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	} finally {
	    manager.close();
	}
    }

    @Override
    public Produto buscar(int id) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return manager.find(Produto.class, id);
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return null;
	} finally {
	    manager.close();
	}
    }

    @Override
    public List<Produto> buscarTodos() {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return manager.createQuery("from Produto p").getResultList();
	} catch (Exception e) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e, null));
	    return null;
	} finally {
	    manager.close();
	}
    }
}
