/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model;

import com.github.jofernando.projeto.tcc.exceptions.CPFNuloException;
import com.github.jofernando.projeto.tcc.exceptions.CPFVazioException;
import com.github.jofernando.projeto.tcc.exceptions.PasswordNuloException;
import com.github.jofernando.projeto.tcc.exceptions.PasswordVazioException;
import com.github.jofernando.projeto.tcc.exceptions.RevendedorNuloException;
import com.github.jofernando.projeto.tcc.exceptions.UsernameCadastradoException;
import com.github.jofernando.projeto.tcc.exceptions.UsernameNuloException;
import com.github.jofernando.projeto.tcc.exceptions.UsernameVazioException;
import com.github.jofernando.projeto.tcc.model.entidades.Revendedor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Jose Junio
 */
public class TesteRevendedor {

    @Rule
    public ExpectedException excecao = ExpectedException.none();

    @Test
    public void devePossuirRevendedorNaoNulo() {
        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(RevendedorNuloException.class);
        excecao.expectMessage("Revendedor não pode ser nulo");
        Revendedor revendedorTeste = null;
        model.inserir(revendedorTeste);
    }

    @Test
    public void deveTerUsernameNaoNulo() {

        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(UsernameNuloException.class);
        excecao.expectMessage("Username não pode ser nulo");
        Revendedor revendedorTeste = new Revendedor();
        revendedorTeste.setPassword("senha");
        model.inserir(revendedorTeste);

    }

    @Test
    public void deveTerUsernameNaoVazio() {

        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(UsernameVazioException.class);
        excecao.expectMessage("Username não pode ser vazio");
        Revendedor revendedorTeste = new Revendedor();
        revendedorTeste.setPassword("senha");
        revendedorTeste.setUsername("");
        model.inserir(revendedorTeste);

    }

    @Test
    public void deveTerPasswordNaoNulo() {

        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(PasswordNuloException.class);
        excecao.expectMessage("Password não pode ser nulo");
        Revendedor revendedorTeste = new Revendedor();
        revendedorTeste.setUsername("Testerevendedor");
        model.inserir(revendedorTeste);

    }

    @Test
    public void deveTerPasswordNaoVazio() {

        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(PasswordVazioException.class);
        excecao.expectMessage("Password não pode ser vazio");
        Revendedor revendedorTeste = new Revendedor();
        revendedorTeste.setUsername("TestRevendedor");
        revendedorTeste.setPassword("");
        model.inserir(revendedorTeste);

    }

    @Test
    public void deveTerUsernameNaoCadastrado() {

        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(UsernameCadastradoException.class);
        excecao.expectMessage("O username já está cadastrado.");
        Revendedor revendedorTeste = new Revendedor();
        revendedorTeste.setUsername("revendedor");
        revendedorTeste.setPassword("senha");
        revendedorTeste.setCpf("123");
        model.inserir(revendedorTeste);

    }

    @Test
    public void deveTerCPFNaoNulo() {

        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(CPFNuloException.class);
        excecao.expectMessage("CPF Não pode ser Nulo.");
        Revendedor revendedorTeste = new Revendedor();
        revendedorTeste.setUsername("revendedor");
        revendedorTeste.setPassword("senha");
        revendedorTeste.setCpf(null);
        model.inserir(revendedorTeste);

    }

    @Test
    public void deveTerCPFNaoVazio() {

        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(CPFVazioException.class);
        excecao.expectMessage("CPF Não pode ser Vazio");
        Revendedor revendedorTeste = new Revendedor();
        revendedorTeste.setUsername("revendedor");
        revendedorTeste.setPassword("senha");
        revendedorTeste.setCpf("");
        model.inserir(revendedorTeste);

    }

    /*
    @Test
    public void deveTerUsernameEPasswordNaoVazios() {

        RevendedorModel model = new RevendedorModel(RevendedorModel.BANCODADOS);
        excecao.expect(PasswordVazioException.class);
        excecao.expect(UsernameVazioException.class);
        excecao.expectMessage("Password não pode ser vazio");
        excecao.expectMessage("Username não pode ser vazio");
        Revendedor revendedor = new Revendedor();
        revendedor.setUsername("");
        revendedor.setPassword("");
        model.inserir(revendedor);

    }*/
}
