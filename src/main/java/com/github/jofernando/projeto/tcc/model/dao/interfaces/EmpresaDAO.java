/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.interfaces;

import com.github.jofernando.projeto.tcc.model.entidades.Empresa;
import com.github.jofernando.projeto.tcc.model.entidades.Usuario;

/**
 *
 * @author Fernando
 */
public interface EmpresaDAO extends DAO<Empresa> {

    Usuario login(String username, String password);

    boolean estaCadastrado(Empresa t);
}
