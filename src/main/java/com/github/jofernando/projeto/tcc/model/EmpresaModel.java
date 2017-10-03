/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model;

import com.github.jofernando.projeto.tcc.model.dao.impl.BancoDeDadosEmpresaDAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.DAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.EmpresaDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Empresa;
import com.github.jofernando.projeto.tcc.util.CriptografiaUtil;
import com.github.jofernando.projeto.tcc.util.SessionUtil;
import java.util.List;

/**
 *
 * @author Jose Junio
 */
public class EmpresaModel {

    private DAO<Empresa> model = null;
    public static final int BANCODADOS = 1;

    public EmpresaModel(int tipo) {
        if (tipo == 1) {
            model = new BancoDeDadosEmpresaDAO();
        }
    }

    public void inserir(Empresa t) {
        try {
            if (t == null) {
                throw new IllegalArgumentException("Empresa não pode ser nula");
            } else if (t.getUsername().isEmpty()) {
                throw new IllegalArgumentException("Username da Empresa não pode ser vazio");
            } else if (t.getPassword().isEmpty()) {
                throw new IllegalArgumentException("Password da Empresa não pode ser vazio");
            } else if (((EmpresaDAO) model).estaCadastrado(t)) {
                //Verificar o tipo correto de exceção.
                throw new IllegalArgumentException("Já existe Empresa com este Username cadastrado");
            }
            t.setPassword(CriptografiaUtil.criptografar(t.getPassword()));
            model.inserir(t);
        } catch (IllegalArgumentException ex) {
        }

    }

    public void alterar(Empresa t) {
        try {
            if (t == null) {
                throw new Exception("Empresa não pode ser nula");
            } else if (t.getUsername().isEmpty()) {
                throw new Exception("Nome da Empresa não pode ser nula");
            } else if (t.getPassword().isEmpty()) {
                throw new Exception("Senha não pode ser nula");
            } else if (((EmpresaDAO) model).estaCadastrado(t)) {
                throw new Exception("Usuário com esse nome já cadastrado");
            }
            t.setPassword(CriptografiaUtil.criptografar(t.getPassword()));
            model.alterar(t);
        } catch (Exception ex) {
        }
    }

    public void deletar(Empresa t) {
        try {
            if (t == null) {
                throw new Exception("Selecione alguma Empresa para excluir");
            }
            model.deletar(t);
        } catch (Exception ex) {
        }
    }

    public Empresa buscar(int id) {
        try {
            return model.buscar(id);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Empresa> buscarTodos() {
        try {
            return model.buscarTodos();
        } catch (Exception ex) {
            return null;
        }
    }

    public void login(String username, String password) {
        try {
            password = CriptografiaUtil.criptografar(password);
            Empresa empresa = (Empresa) ((EmpresaDAO) model).login(username, password);
            if (empresa != null) {
                SessionUtil.setAttribute("EmpresaLogada", empresa);
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
