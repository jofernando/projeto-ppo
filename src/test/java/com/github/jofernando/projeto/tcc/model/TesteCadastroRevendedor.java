/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model;

import com.github.jofernando.projeto.tcc.model.entidades.Revendedor;
import com.github.jofernando.projeto.tcc.model2.RevendedorModel;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Jose Junio
 */
public class TesteCadastroRevendedor {

    @Rule
    public ExpectedException excecao = ExpectedException.none();

    @Test
    public void deveTerUsernameNaoCadastrado() {

        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(IllegalArgumentException.class);
        excecao.expectMessage("Usuário com esse nome já cadastrado");
        Revendedor revendedor = new Revendedor();
        revendedor.setPassword("12345");
        revendedor.setUsername("jrjr");
        model.inserir(revendedor);

    }

}
