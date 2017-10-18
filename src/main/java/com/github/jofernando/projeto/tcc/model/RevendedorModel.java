/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model;

import com.github.jofernando.projeto.tcc.exceptions.CPFNuloException;
import com.github.jofernando.projeto.tcc.exceptions.CPFVazioException;
import com.github.jofernando.projeto.tcc.exceptions.PasswordNuloException;
import com.github.jofernando.projeto.tcc.exceptions.PasswordVazioException;
import com.github.jofernando.projeto.tcc.exceptions.RevendedorNuloException;
import com.github.jofernando.projeto.tcc.exceptions.UsernameCadastradoException;
import com.github.jofernando.projeto.tcc.exceptions.UsernameNuloException;
import com.github.jofernando.projeto.tcc.exceptions.UsernameVazioException;
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

        if (t == null) {
            throw new RevendedorNuloException();
        } else if (t.getUsername() == null) {
            throw new UsernameNuloException();
        } else if (t.getUsername().isEmpty()) {
            throw new UsernameVazioException();
        } else if (t.getPassword() == null) {
            throw new PasswordNuloException();
        } else if (t.getPassword().isEmpty()) {
            throw new PasswordVazioException();
        } else if (t.getCpf() == null) {
            throw new CPFNuloException();
        } else if (t.getCpf().isEmpty()) {
            throw new CPFVazioException();
        } else if (((RevendedorDAO) model).estaCadastrado(t)) {
            throw new UsernameCadastradoException();
        }
        t.setPassword(CriptografiaUtil.criptografar(t.getPassword()));
        model.inserir(t);

    }

    public void alterar(Revendedor t) {
        if (t == null) {
            throw new RevendedorNuloException();
        } else if (t.getUsername() == null) {
            throw new UsernameNuloException();
        } else if (t.getUsername().isEmpty()) {
            throw new UsernameVazioException();
        } else if (t.getPassword() == null) {
            throw new PasswordNuloException();
        } else if (t.getPassword().isEmpty()) {
            throw new PasswordVazioException();
        } else if (((RevendedorDAO) model).estaCadastrado(t)) {
            throw new UsernameCadastradoException();
        }
        t.setPassword(CriptografiaUtil.criptografar(t.getPassword()));
        model.alterar(t);
    }

    public void deletar(Revendedor t) {
        if (t == null) {
            throw new IllegalArgumentException("Selecione algum Revendedor para excluir");
        }
        model.deletar(t);
    }

    public Revendedor buscar(int id) {
        return model.buscar(id);
    }

    public List<Revendedor> buscarTodos() {
        return model.buscarTodos();
    }

    public void login(String username, String password) {
        password = CriptografiaUtil.criptografar(password);
        Revendedor revendedor = ((RevendedorDAO) model).login(username, password);
        if (revendedor != null) {
            SessionUtil.setAttribute("RevendedorLogado", revendedor);
        } else {
            throw new IllegalArgumentException("Usuario e/ou senha inválidos");
        }
    }

    public void logout() {
        SessionUtil.invalidate();
    }
}
