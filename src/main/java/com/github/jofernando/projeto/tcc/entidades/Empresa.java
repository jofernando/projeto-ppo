/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Jose Junio
 */
@Entity
public class Empresa implements Serializable {

    @Id
    private int id;
    private String nomeFantasia;
    private String cnpf;
    private String username;
    private String password;
    private String razaoSocial;

    public Empresa() {
    }

    public Empresa(String nomeFantasia, String cnpf, String username, String password, String razaoSocial) {
        this.nomeFantasia = nomeFantasia;
        this.cnpf = cnpf;
        this.username = username;
        this.password = password;
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpf() {
        return cnpf;
    }

    public void setCnpf(String cnpf) {
        this.cnpf = cnpf;
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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.cnpf);
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
        final Empresa other = (Empresa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cnpf, other.cnpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nomeFantasia=" + nomeFantasia + ", cnpf=" + cnpf + ", username=" + username + ", razaoSocial=" + razaoSocial + '}';
    }

}
