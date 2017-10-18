/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.entidades;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Jose Junio
 */
@MappedSuperclass
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String nome;

    public Usuario() {

    }

    public Usuario(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
