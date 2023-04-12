package org.mobydigital.marias.servlet;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.servlet.entity.Educacion;
import org.mobydigital.marias.servlet.util.JpaUtil;

import java.util.List;

public class PortafolioApp {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManagerFactory();
        List< Educacion > listaEducacion = em.createQuery("select e from Educacion e").getResultList();
        listaEducacion.forEach(System.out::println);
        em.close();
    }
}
