/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model2;

import com.github.jofernando.projeto.tcc.model.dao.impl.BancoDeDadosPedidoDAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.DAO;
import com.github.jofernando.projeto.tcc.model.dao.interfaces.PedidoDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Pedido;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class PedidoModel {

    private DAO<Pedido> model = null;
    public static final int BANCODADOS = 1;

    public PedidoModel(int tipo) {
	if (tipo == BANCODADOS) {
	    model = new BancoDeDadosPedidoDAO();
	}
    }

    public void inserir(Pedido t) {
	if (t == null) {
	    throw new IllegalArgumentException("Pedido não pode ser nulo");
	} else if (t.getCliente() == null) {
	    throw new IllegalArgumentException("Cliente não pode ser nulo");
	} else if (t.getItens() == null || t.getItens().isEmpty()) {
	    throw new IllegalArgumentException("Pedido tem que ter pelo menos 1 item");
	} else if (t.getCampanha().isEmpty()) {
	    throw new IllegalArgumentException("Campanha não pode ser nulo");
	} else if (((PedidoDAO) model).estaCadastrado(t)) {
	    throw new IllegalArgumentException("Pedido com esse cliente e campanha já cadastrado");
	}
	model.inserir(t);
    }

    public void alterar(Pedido t) {
	if (t == null) {
	    throw new IllegalArgumentException("Pedido não pode ser nulo");
	} else if (t.getCliente() == null) {
	    throw new IllegalArgumentException("Cliente não pode ser nulo");
	} else if (t.getItens().isEmpty() || t.getItens() == null) {
	    throw new IllegalArgumentException("Pedido tem que ter pelo menos 1 item");
	} else if (t.getCampanha() == null) {
	    throw new IllegalArgumentException("Campanha não pode ser nulo");
	} else if (((PedidoDAO) model).estaCadastrado(t)) {
	    throw new IllegalArgumentException("Pedido com esse cliente e campanha já cadastrado");
	}
	model.alterar(t);
    }

    public void deletar(Pedido t) {
	if (t == null) {
	    throw new IllegalArgumentException("Selecione algum pedido para excluir");
	}
	model.deletar(t);
    }

    public Pedido buscar(int id) {
	return model.buscar(id);
    }

    public List<Pedido> buscarTodos() {
	return model.buscarTodos();
    }
}
