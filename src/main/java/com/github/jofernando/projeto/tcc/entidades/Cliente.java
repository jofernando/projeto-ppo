/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author 20161D13GR0155
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cpf;

    // @ManyToOne
    // private UsuarioN usuario;
    public Cliente() {
    }

    public Cliente(String nome, String email, String telefone, String endereco, String cpf) {
	this.nome = nome;
	this.email = email;
	this.telefone = telefone;
	this.endereco = endereco;
	this.cpf = cpf;
    }

    public int getId() {
	return id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    public String getEndereco() {
	return endereco;
    }

    public void setEndereco(String endereco) {
	this.endereco = endereco;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    /*public UsuarioN getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioN usuario) {
        this.usuario = usuario;
    }*/
    @Override
    public int hashCode() {
	int hash = 7;
	hash = 17 * hash + this.id;
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Cliente other = (Cliente) obj;
	if (this.id != other.id) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Cliente{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", endereco=" + endereco + ", cpf=" + cpf + '}';
    }

}
