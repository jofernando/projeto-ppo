/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model;

import com.github.jofernando.projeto.tcc.model.dao.impl.BancoDeDadosRevendedorDAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.DAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.RevendedorDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Revendedor;
import com.github.jofernando.projeto.tcc.util.CriptografiaUtil;
import com.github.jofernando.projeto.tcc.util.SessionUtil;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class RevendedorModel {

    private DAO<Revendedor> model = null;
    public static final int BANCODADOS = 1;

    public RevendedorModel(int tipo) {
        if (tipo == 1) {
            model = new BancoDeDadosRevendedorDAO();
        }
    }

    public void inserir(Revendedor t) {
        try {
            if (t == null) {
                throw new Exception("Revendedor não pode ser nulo");
            } else if (t.getUsername().isEmpty()) {
                throw new Exception("Nome do Revendedor não pode ser nulo");
            } else if (t.getPassword().isEmpty()) {
                throw new Exception("Senha não pode ser nulo");
            } else if (((RevendedorDAO) model).estaCadastrado(t)) {
                throw new Exception("Usuário com esse nome já cadastrado");
            }
            t.setPassword(CriptografiaUtil.criptografar(t.getPassword()));
            model.inserir(t);
        } catch (Exception ex) {
        }

    }

    public void alterar(Revendedor t) {
        try {
            if (t == null) {
                throw new Exception("Revendedor não pode ser nulo");
            } else if (t.getUsername().isEmpty()) {
                throw new Exception("Nome do Revendedor não pode ser nulo");
            } else if (t.getPassword().isEmpty()) {
                throw new Exception("Senha não pode ser nula");
            } else if (((RevendedorDAO) model).estaCadastrado(t)) {
                throw new Exception("Usuário com esse nome já cadastrado");
            }
            t.setPassword(CriptografiaUtil.criptografar(t.getPassword()));
            model.alterar(t);
        } catch (Exception ex) {
        }
    }

    public void deletar(Revendedor t) {
        try {
            if (t == null) {
                throw new Exception("Selecione algum Revendedor para excluir");
            }
            model.deletar(t);
        } catch (Exception ex) {
        }
    }

    public Revendedor buscar(int id) {
        try {
            return model.buscar(id);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Revendedor> buscarTodos() {
        try {
            return model.buscarTodos();
        } catch (Exception ex) {
            return null;
        }
    }

    public void login(String username, String password) {
        try {
            password = CriptografiaUtil.criptografar(password);
            Revendedor revendedor = ((RevendedorDAO) model).login(username, password);
            if (revendedor != null) {
                SessionUtil.setAttribute("RevendedorLogado", revendedor);
            } else {
                throw new Exception("Usuario e/ou senha inválidos");
            }
        } catch (Exception ex) {
        }
    }

    public void logout() {
        try {
            SessionUtil.invalidate();
        } catch (Exception ex) {
        }
    }
}
