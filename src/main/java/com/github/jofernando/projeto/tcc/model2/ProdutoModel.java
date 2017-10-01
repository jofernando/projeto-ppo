/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model2;

import com.github.jofernando.projeto.tcc.model.dao.impl.BancoDeDadosProdutoDAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.DAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.ProdutoDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Produto;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ProdutoModel {

    private DAO<Produto> model = null;
    public static final int BANCODADOS = 1;

    public ProdutoModel(int tipo) {
	if (tipo == BANCODADOS) {
	    model = new BancoDeDadosProdutoDAO();
	}
    }

    public void inserir(Produto t) {
	if (t == null) {
	    throw new IllegalArgumentException("Produto não pode ser nulo");
	} else if (t.getCodigo().isEmpty()) {
	    throw new IllegalArgumentException("Código não pode ser nulo");
	} else if (((ProdutoDAO) model).estaCadastrado(t)) {
	    throw new IllegalArgumentException("Produto com este código já cadastrado");
	}
	model.inserir(t);
    }

    public void alterar(Produto t) {
	if (t == null) {
	    throw new IllegalArgumentException("Produto não pode ser nulo");
	} else if (t.getCodigo().isEmpty()) {
	    throw new IllegalArgumentException("Código não pode ser nulo");
	} else if (((ProdutoDAO) model).estaCadastrado(t)) {
	    throw new IllegalArgumentException("Produto com este código já cadastrado");
	}
	model.alterar(t);
    }

    public void deletar(Produto t) {
	if (t == null) {
	    throw new IllegalArgumentException("Selecione um produto para excluir");
	}
	model.deletar(t);
    }

    public Produto buscar(int id) {
	return model.buscar(id);
    }

    public List<Produto> buscarTodos() {
	return model.buscarTodos();
    }

    public Produto buscarPorCodigo(String codigo) {
	return ((ProdutoDAO) model).buscarPorCodigo(codigo);
    }
}
