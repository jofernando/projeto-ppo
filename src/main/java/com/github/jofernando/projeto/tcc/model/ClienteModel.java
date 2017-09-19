/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model;

import com.github.jofernando.projeto.tcc.model.dao.impl.BancoDeDadosClienteDAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.ClienteDAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.DAO;
import com.github.jofernando.projeto.tcc.model.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ClienteModel {

    private DAO<Cliente> model = null;
    public static final int BANCODADOS = 1;

    public ClienteModel(int tipoArmazenamento) {
	if (tipoArmazenamento == BANCODADOS) {
	    model = new BancoDeDadosClienteDAO();
	}
    }

    public void inserir(Cliente t) {
	if (t.getCpf().isEmpty()) {
	    throw new IllegalArgumentException("CPF não pode ser nulo");
	} else if (t == null) {
	    throw new IllegalArgumentException("Cliente não pode ser nulo");
	} else if (((ClienteDAO) model).estaCadastrado(t)) {
	    throw new IllegalArgumentException("Cliente com esse CPF já cadastrado");
	}
	model.inserir(t);

    }

    public void alterar(Cliente t) {
	if (t == null) {
	    throw new IllegalArgumentException("Cliente não pode ser nulo");
	} else if (t.getCpf().isEmpty()) {
	    throw new IllegalArgumentException("CPF não pode ser nulo");
	} else if (((ClienteDAO) model).estaCadastrado(t)) {
	    throw new IllegalArgumentException("Cliente com esse CPF já cadastrado");
	}
	model.alterar(t);
    }

    public void deletar(Cliente t) {
	if (t == null) {
	    throw new IllegalArgumentException("Selecione algum cliente para excluir");
	}
	model.deletar(t);
    }

    public Cliente buscar(int id) {
	return model.buscar(id);
    }

    public List<Cliente> buscarTodos() {
	return model.buscarTodos();
    }

    public Cliente buscarPorCpf(String cpf) {
	return ((ClienteDAO) model).buscarPorCpf(cpf);
    }
}
