/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model.dao.interfaces;

import java.util.List;

/**
 *
 * @author Jose Junio
 */
public interface DAO<T> {

    void inserir(T t);

    void alterar(T t);

    void deletar(T t);

    T buscar(int id);

    List<T> buscarTodos();

}
