/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.controller;

import com.github.jofernando.projeto.tcc.model.entidades.Empresa;
import com.github.jofernando.projeto.tcc.model.entidades.Usuario;
import com.github.jofernando.projeto.tcc.model.EmpresaModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@SessionScoped
public class EmpresaController {

    private EmpresaModel model = null;
    private Empresa empresa;

    public EmpresaController() {
        model = new EmpresaModel(EmpresaModel.BANCODADOS);
        empresa = new Empresa();
    }

    public void inserirAction() {
        model.inserir(empresa);
        limpar();
    }

    public void alterarAction() {
        model.alterar(empresa);
    }

    public void deletarAction() {
        model.deletar(empresa);
    }

    public Usuario buscarAction(int id) {
        return model.buscar(id);
    }

    public List<Empresa> buscarTodosAction() {
        return model.buscarTodos();
    }

    public void loginAction() {
        model.login(empresa.getUsername(), empresa.getPassword());
    }

    public void logoutAction() {
        model.logout();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void limpar() {
        empresa = new Empresa();
    }

}
