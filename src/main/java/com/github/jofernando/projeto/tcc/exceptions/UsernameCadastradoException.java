/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.exceptions;

/**
 *
 * @author Jose Junio
 */
public class UsernameCadastradoException extends RegraDeNegocioException {

    public UsernameCadastradoException() {
        super("O username já está cadastrado.");
    }

}
