/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.projeto.tcc.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fernando
 */
public class JpaUtil {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("UnidadeDePersistencia");

    /*
    static {
        FACTORY = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
    }
     */
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

    public static void close() {
        FACTORY.close();
    }
}
