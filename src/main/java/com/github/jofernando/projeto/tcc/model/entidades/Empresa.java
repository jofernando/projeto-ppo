/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Jose Junio
 */
@Entity
public class Empresa extends Usuario implements Serializable {

    private String nomeFantasia;
    private String cnpj;
    private String razaoSocial;
    @OneToMany
    private Set<Revendedor> revendedores;
    @OneToMany
    private Set<Produto> produtos;

    public Empresa() {
    }

    public Empresa(String nomeFantasia, String cnpj, String razaoSocial, String username, String password) {
        super(username, password);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.revendedores = new HashSet<>();
        this.produtos = new HashSet<>();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Set<Revendedor> getRevendedores() {
        return revendedores;
    }

    public void setRevendedores(Set<Revendedor> revendedores) {
        this.revendedores = revendedores;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cnpj);
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
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", revendedores=" + revendedores + ", produtos=" + produtos + '}';
    }

}
