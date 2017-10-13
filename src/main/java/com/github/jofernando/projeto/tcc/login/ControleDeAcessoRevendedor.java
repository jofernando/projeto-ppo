/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.login;

import com.github.jofernando.projeto.tcc.model.entidades.Revendedor;
import com.github.jofernando.projeto.tcc.model.entidades.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fernando
 */
//@WebFilter("/revendedor/*")
public class ControleDeAcessoRevendedor implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	try {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    HttpSession session = req.getSession();
	    Usuario usuario = (Usuario) session.getAttribute("UsuarioLogado");
	    boolean value = (usuario != null && usuario instanceof Revendedor) || req.getRequestURI().endsWith("login.xhtml");
	    if (value) {
		chain.doFilter(request, response);
	    } else {
		res.sendRedirect("/projeto-tcc/acesso-negado.xhtml");
	    }
	} catch (IOException | ServletException ex) {
	    System.err.println(ex);
	}
    }

    @Override
    public void destroy() {
    }

}
