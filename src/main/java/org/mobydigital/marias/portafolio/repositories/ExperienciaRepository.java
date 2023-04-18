package org.mobydigital.marias.portafolio.repositories;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.entities.Experiencia;

import java.util.List;

public class ExperienciaRepository implements CrudRepository<Experiencia> {
    private EntityManager em;

    public ExperienciaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Experiencia> listar() {
        return em.createQuery("SELECT e FROM Experiencia e", Experiencia.class).getResultList();
    }

    @Override
    public Experiencia porId(Long id) {
        return em.find(Experiencia.class,id);
    }

    @Override
    public void guardar(Experiencia experiencia) {
        if(experiencia.getIdExperiencia() !=null && experiencia.getIdExperiencia()>0){
            em.merge(experiencia);
        }else{
            em.persist(experiencia);
        }
    }

    @Override
    public void eliminar(Long id) {
        Experiencia experiencia = porId(id);
        em.remove(experiencia);
    }
}
