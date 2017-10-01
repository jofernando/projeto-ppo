/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.controller;

import com.github.jofernando.projeto.tcc.model.entidades.Produto;
import com.github.jofernando.projeto.tcc.model2.ProdutoModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class ProdutoController {

    private ProdutoModel model = null;
    private Produto produto;

    public ProdutoController() {
        model = new ProdutoModel(ProdutoModel.BANCODADOS);
        produto = new Produto();
    }

    public void inserirAction() {
        model.inserir(produto);
    }

    public void alterarAction() {
        model.alterar(produto);
    }

    public void deletarAction() {
        model.deletar(produto);
    }

    public void deletarAction(Produto produto) {
        model.deletar(produto);
    }

    public Produto buscarAction(int id) {
        return model.buscar(id);
    }

    public List<Produto> buscarTodosAction() {
        return model.buscarTodos();
    }

    public Produto buscarPorCpfAction(String codigo) {
        return model.buscarPorCodigo(codigo);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void limpar() {
        produto = new Produto();
    }

}
