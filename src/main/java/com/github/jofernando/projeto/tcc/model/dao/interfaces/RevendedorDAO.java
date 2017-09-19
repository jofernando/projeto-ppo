/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.interfaces;

import com.github.jofernando.projeto.tcc.model.entidades.Revendedor;

/**
 *
 * @author Fernando
 */
public interface RevendedorDAO extends DAO<Revendedor> {

    Revendedor login(String username, String password);

    boolean estaCadastrado(Revendedor t);
}
