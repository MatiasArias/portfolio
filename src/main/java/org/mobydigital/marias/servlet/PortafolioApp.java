package org.mobydigital.marias.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.mobydigital.marias.portafolio.models.Educacion;
import org.mobydigital.marias.servlet.util.JpaUtil;

import java.util.List;

public class PortafolioApp {
    public static void main(String[] args) {
    where();
    }
    public static void select(){
        EntityManager em = JpaUtil.getEntityManagerFactory();
        List< Educacion > listaEducacion = em.createQuery("select e from Educacion e").getResultList();
        listaEducacion.forEach(System.out::println);
        em.close();
    }
    public static void where(){
        EntityManager em = JpaUtil.getEntityManagerFactory();
        Query query = em.createQuery("select e from Educacion e where e.añoIngreso=?1",Educacion.class);
        query.setParameter(1,2019);
        Educacion e = (Educacion) query.getSingleResult();
        System.out.println(e);
        em.close();
    }
}
