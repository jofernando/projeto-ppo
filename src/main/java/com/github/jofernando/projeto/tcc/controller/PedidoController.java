/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.controller;

import com.github.jofernando.projeto.tcc.model.entidades.Pedido;
import com.github.jofernando.projeto.tcc.model.entidades.Produto;
import com.github.jofernando.projeto.tcc.model.PedidoModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class PedidoController {

    private PedidoModel model = null;
    private Pedido pedido;
    private List<Produto> produtos;

    public PedidoController() {
        model = new PedidoModel(PedidoModel.BANCODADOS);
        pedido = new Pedido();
    }

    public void inserirAction() {
        model.inserir(pedido);
    }

    public void alterarAction() {
        model.alterar(pedido);
    }

    public void deletarAction() {
        model.deletar(pedido);
    }

    public void deletarAction(Pedido pedido) {
        model.deletar(pedido);
    }

    public Pedido buscarAction(int id) {
        return model.buscar(id);
    }

    public List<Pedido> buscarTodosAction() {
        return model.buscarTodos();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void limpar() {
        pedido = new Pedido();
        produtos = null;
    }

}
