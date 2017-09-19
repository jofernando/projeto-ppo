/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.controller;

import com.github.jofernando.projeto.tcc.model.ClienteModel;
import com.github.jofernando.projeto.tcc.model.entidades.Cliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class ClienteController {

    private ClienteModel model = null;
    private Cliente cliente;

    public ClienteController() {
        model = new ClienteModel(ClienteModel.BANCODADOS);
        cliente = new Cliente();
    }

    public void inserirAction() {
        model.inserir(cliente);
    }

    public void alterarAction() {
        model.alterar(cliente);
    }

    public void deletarAction() {
        model.deletar(cliente);
    }

    public void deletarAction(Cliente cliente) {
        model.deletar(cliente);
    }

    public Cliente buscarAction(int id) {
        return model.buscar(id);
    }

    public List<Cliente> buscarTodosAction() {
        return model.buscarTodos();
    }

    public Cliente buscarPorCpfAction(String cpf) {
        return model.buscarPorCpf(cpf);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
