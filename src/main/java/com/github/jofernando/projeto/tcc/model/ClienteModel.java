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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
	try {
	    if (t.getCpf().isEmpty()) {
		throw new Exception("CPF não pode ser nulo");
	    } else if (t == null) {
		throw new Exception("Cliente não pode ser nulo");
	    } else if (((ClienteDAO) model).estaCadastrado(t)) {
		throw new Exception("Cliente com esse CPF já cadastrado");
	    }
	    model.inserir(t);
	} catch (Exception ex) {
	    //Substituir como lançar a execessão
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + ex.getMessage(), null));
	}

    }

    public void alterar(Cliente t) {
	try {
	    if (t == null) {
		throw new Exception("Cliente não pode ser nulo");
	    } else if (t.getCpf().isEmpty()) {
		throw new Exception("CPF não pode ser nulo");
	    } else if (((ClienteDAO) model).estaCadastrado(t)) {
		throw new Exception("Cliente com esse CPF já cadastrado");
	    }
	    model.alterar(t);
	} catch (Exception ex) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + ex.getMessage(), null));
	}
    }

    public void deletar(Cliente t) {
	try {
	    if (t == null) {
		throw new Exception("Selecione algum cliente para excluir");
	    }
	    model.deletar(t);
	} catch (Exception ex) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + ex.getMessage(), null));
	}
    }

    public Cliente buscar(int id) {
	try {
	    return model.buscar(id);
	} catch (Exception ex) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + ex.getMessage(), null));
	    return null;
	}
    }

    public List<Cliente> buscarTodos() {
	try {
	    return model.buscarTodos();
	} catch (Exception ex) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + ex.getMessage(), null));
	    return null;
	}
    }

    public Cliente buscarPorCpf(String cpf) {
	try {
	    return ((ClienteDAO) model).buscarPorCpf(cpf);
	} catch (Exception ex) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + ex.getMessage(), null));
	    return null;
	}
    }
}
