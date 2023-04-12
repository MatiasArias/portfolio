package org.mobydigital.marias.servlet.repositories;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.servlet.entity.Educacion;

import java.util.List;

public class EducacionRepositorio implements CrudRepository<Educacion> {
    private EntityManager em;

    public EducacionRepositorio(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Educacion> listar() {
        return em.createQuery("SELECT e FROM Educacion e",Educacion.class).getResultList();
    }

    @Override
    public Educacion porId(Long id) {
        return em.find(Educacion.class,id);
    }

    @Override
    public void guardar(Educacion educacion) {
        if (educacion.getIdEducacion() !=null && educacion.getIdEducacion() > 0){
            em.merge(educacion);
        }
        else{
        em.persist(educacion);
        }
    }

    @Override
    public void eliminar(Long id) {
        Educacion educacion = porId(id);
        em.remove(educacion);
    }
}
