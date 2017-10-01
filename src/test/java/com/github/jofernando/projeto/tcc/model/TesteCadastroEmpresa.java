/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Jose Junio
 */
public class TesteCadastroEmpresa {

    @Rule
    public ExpectedException excecao = ExpectedException.none();

    /* @Test
    public void deveTerUsernameNaoCadastrado() {

        EmpresaModel model = new EmpresaModel(1);
        excecao.expect(IllegalArgumentException.class);
        excecao.expectMessage("Username da Empresa não pode ser vazio");
        Empresa empresa = new Empresa();
        empresa.setPassword("12345");
        empresa.setUsername("login");
        model.inserir(empresa);
    }
    @Test
    public void deveCadastrarEmpresa() {

        EmpresaModel model = new EmpresaModel(1);
        Empresa empresa = new Empresa();
        empresa.setPassword("12345");
        empresa.setUsername("login");
        model.inserir(empresa);

        Assert.assertEquals(model.buscar(12), "login");

    }

    /* @Test
    public void deveTerEmailNaoVazio() {
        excecao.expect(IllegalArgumentException.class);
        excecao.expectMessage("e-mail de usuário inválido");
        new Usuario("", "Ana da Silva");
    }

    @Test
    public void deveTerNomeNaoNulo() {
        excecao.expect(IllegalArgumentException.class);
        excecao.expectMessage("nome de usuário inválido");
        new Usuario("ana@gmail.com", null);
    }

    @Test
    public void deveTerNomeNaoVazio() {
        excecao.expect(IllegalArgumentException.class);
        excecao.expectMessage("nome de usuário inválido");
        new Usuario("ana@gmail.com", "");
    }

     */
}
