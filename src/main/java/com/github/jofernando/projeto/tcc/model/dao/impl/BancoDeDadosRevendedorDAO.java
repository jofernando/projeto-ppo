/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.impl;

import com.github.jofernando.projeto.tcc.model.dao.interfaces.RevendedorDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Revendedor;
import com.github.jofernando.projeto.tcc.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Fernando
 */
public class BancoDeDadosRevendedorDAO implements RevendedorDAO {

    @Override
    public Revendedor login(String username, String password) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return (Revendedor) manager.createQuery("from Revendedor u where u.username = :username"
		    + " and u.password = :password")
		    .setParameter("username", username)
		    .setParameter("password", password)
		    .getSingleResult();
	} catch (IllegalArgumentException e) {
	    return null;
	} finally {
	    manager.close();
	}
    }

    @Override
    public boolean estaCadastrado(Revendedor t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    List<Revendedor> revendedores = manager.createQuery("from Revendedor u where u.username = :username")
		    .setParameter("username", t.getUsername())
		    .getResultList();
	    if (t.getId() != 0 && revendedores.size() == 1 && revendedores.get(0).getId() == (t.getId())) {
		return false;
	    }
	    return !revendedores.isEmpty();
	} catch (Exception e) {
	    return false;
	} finally {
	    manager.close();
	}
    }

    @Override
    public void inserir(Revendedor t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.persist(t);
	    manager.getTransaction().commit();
	} catch (Exception e) {
	} finally {
	    manager.close();
	}
    }

    @Override
    public void alterar(Revendedor t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.merge(t);
	    manager.getTransaction().commit();
	} catch (Exception e) {
	} finally {
	    manager.close();
	}
    }

    @Override
    public void deletar(Revendedor t) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.remove(manager.merge(t));
	    manager.getTransaction().commit();
	} catch (Exception e) {
	} finally {
	    manager.close();
	}
    }

    @Override
    public Revendedor buscar(int id) {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return (Revendedor) manager.find(Revendedor.class, id);
	} catch (Exception e) {
	    return null;
	} finally {
	    manager.close();
	}
    }

    @Override
    public List<Revendedor> buscarTodos() {
	EntityManager manager = JpaUtil.getEntityManager();
	try {
	    return manager.createQuery("from Revendedor u").getResultList();
	} catch (Exception e) {
	    return null;
	} finally {
	    manager.close();
	}
    }

}
