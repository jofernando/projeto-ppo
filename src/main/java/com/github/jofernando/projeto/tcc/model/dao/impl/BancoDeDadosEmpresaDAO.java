/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.impl;

import com.github.jofernando.projeto.tcc.model.dao.interfaces.EmpresaDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Empresa;
import com.github.jofernando.projeto.tcc.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Jose Junio
 */
public class BancoDeDadosEmpresaDAO implements EmpresaDAO {

    @Override
    public Empresa login(String username, String password) {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            return (Empresa) manager.createQuery("from Empresa u where u.username = :username"
                    + " and u.password = :password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean estaCadastrado(Empresa t) {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            List<Empresa> empresas = manager.createQuery("from Empresa u where u.username = :username")
                    .setParameter("username", t.getUsername())
                    .getResultList();
            if (t.getId() != 0 && empresas.size() == 1 && empresas.get(0).getId() == (t.getId())) {
                return false;
            }
            return !empresas.isEmpty();
        } catch (Exception e) {
            return false;
        } finally {
            manager.close();
        }
    }

    @Override
    public void inserir(Empresa t) {
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
    public void alterar(Empresa t) {
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
    public void deletar(Empresa t) {
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
    public Empresa buscar(int id) {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            return (Empresa) manager.find(Empresa.class, id);
        } catch (Exception e) {
            return null;
        } finally {
            manager.close();
        }
    }

    @Override
    public List<Empresa> buscarTodos() {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            return manager.createQuery("from Empresa u").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            manager.close();
        }
    }

}
