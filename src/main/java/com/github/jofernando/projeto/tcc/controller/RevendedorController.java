/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.controller;

import com.github.jofernando.projeto.tcc.model.RevendedorModel;
import com.github.jofernando.projeto.tcc.model.entidades.Revendedor;
import com.github.jofernando.projeto.tcc.model.entidades.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class RevendedorController {

    private RevendedorModel model = null;
    private Revendedor revendedor;

    public RevendedorController() {
        model = new RevendedorModel(RevendedorModel.BANCODADOS);
        revendedor = new Revendedor();
    }

    public void inserirAction() {
        model.inserir(revendedor);
    }

    public void alterarAction() {
        model.alterar(revendedor);
    }

    public void deletarAction() {
        model.deletar(revendedor);
    }

    public Usuario buscarAction(int id) {
        return model.buscar(id);
    }

    public List<Revendedor> buscarTodosAction() {
        return model.buscarTodos();
    }

    public void loginAction() {
        model.login(revendedor.getUsername(), revendedor.getPassword());
    }

    public void logoutAction() {
        model.logout();
    }

    public Usuario getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public void limpar() {
        revendedor = new Revendedor();
    }

}
