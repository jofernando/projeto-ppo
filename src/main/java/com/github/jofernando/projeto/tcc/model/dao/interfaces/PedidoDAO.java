/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.interfaces;

import com.github.jofernando.projeto.tcc.model.entidades.Pedido;

/**
 *
 * @author Fernando
 */
public interface PedidoDAO extends DAO<Pedido> {

    boolean estaCadastrado(Pedido t);
}
