/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.model;

import com.github.jofernando.projeto.tcc.exceptions.CNPJNuloException;
import com.github.jofernando.projeto.tcc.exceptions.CNPJVazioException;
import com.github.jofernando.projeto.tcc.exceptions.EmpresaNulaException;
import com.github.jofernando.projeto.tcc.exceptions.PasswordNuloException;
import com.github.jofernando.projeto.tcc.exceptions.PasswordVazioException;
import com.github.jofernando.projeto.tcc.exceptions.UsernameCadastradoException;
import com.github.jofernando.projeto.tcc.exceptions.UsernameNuloException;
import com.github.jofernando.projeto.tcc.exceptions.UsernameVazioException;
import com.github.jofernando.projeto.tcc.model.entidades.Empresa;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Jose Junio
 */
public class TesteEmpresa {

    @Rule
    public ExpectedException excecao = ExpectedException.none();

    @Test
    public void devePossuirEmpresaNaoNula() {
        EmpresaModel model = new EmpresaModel(EmpresaModel.BANCODADOS);
        excecao.expect(EmpresaNulaException.class);
        excecao.expectMessage("Empresa não pode ser nula");
        Empresa empresaTeste = null;
        model.inserir(empresaTeste);
    }

    @Test
    public void deveTerUsernameNaoNulo() {

        EmpresaModel model = new EmpresaModel(EmpresaModel.BANCODADOS);
        excecao.expect(UsernameNuloException.class);
        excecao.expectMessage("Username não pode ser nulo");
        Empresa empresaTeste = new Empresa();
        empresaTeste.setPassword("senha");
        model.inserir(empresaTeste);

    }

    @Test
    public void deveTerUsernameNaoVazio() {

        EmpresaModel model = new EmpresaModel(EmpresaModel.BANCODADOS);
        excecao.expect(UsernameVazioException.class);
        excecao.expectMessage("Username não pode ser vazio");
        Empresa empresaTeste = new Empresa();
        empresaTeste.setPassword("senha");
        empresaTeste.setUsername("");
        model.inserir(empresaTeste);

    }

    @Test
    public void deveTerPasswordNaoNulo() {

        EmpresaModel model = new EmpresaModel(EmpresaModel.BANCODADOS);
        excecao.expect(PasswordNuloException.class);
        excecao.expectMessage("Password não pode ser nulo");
        Empresa empresaTeste = new Empresa();
        empresaTeste.setUsername("TesteEmpresa");
        model.inserir(empresaTeste);

    }

    @Test
    public void deveTerPasswordNaoVazio() {

        EmpresaModel model = new EmpresaModel(EmpresaModel.BANCODADOS);
        excecao.expect(PasswordVazioException.class);
        excecao.expectMessage("Password não pode ser vazio");
        Empresa empresaTeste = new Empresa();
        empresaTeste.setUsername("TesteEmpresa");
        empresaTeste.setPassword("");
        model.inserir(empresaTeste);

    }

    @Test
    public void deveTerUsernameNaoCadastrado() {

        EmpresaModel model = new EmpresaModel(EmpresaModel.BANCODADOS);
        excecao.expect(UsernameCadastradoException.class);
        excecao.expectMessage("O username já está cadastrado.");
        Empresa empresaTeste = new Empresa();
        empresaTeste.setUsername("empresa");
        empresaTeste.setPassword("senha");
        empresaTeste.setCnpj("123");
        model.inserir(empresaTeste);
    }

    @Test
    public void deveTerCNPJNaoNulo() {

        EmpresaModel model = new EmpresaModel(EmpresaModel.BANCODADOS);
        excecao.expect(CNPJNuloException.class);
        excecao.expectMessage("CNPJ da Empresa nao deve ser Nulo.");
        Empresa empresaTeste = new Empresa();
        empresaTeste.setUsername("empresa");
        empresaTeste.setPassword("senha");
        empresaTeste.setCnpj(null);
        model.inserir(empresaTeste);
    }

    @Test
    public void deveTerCNPJNaoVazio() {

        EmpresaModel model = new EmpresaModel(EmpresaModel.BANCODADOS);
        excecao.expect(CNPJVazioException.class);
        excecao.expectMessage("CNPJ da Empresa não pode ser vazio.");
        Empresa empresaTeste = new Empresa();
        empresaTeste.setUsername("empresa");
        empresaTeste.setPassword("senha");
        empresaTeste.setCnpj("");
        model.inserir(empresaTeste);
    }
}
