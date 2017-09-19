/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.interfaces;

import com.github.jofernando.projeto.tcc.model.entidades.Produto;

/**
 *
 * @author Fernando
 */
public interface ProdutoDAO extends DAO<Produto> {

    Produto buscarPorCodigo(String codigo);

    boolean estaCadastrado(Produto t);
}
