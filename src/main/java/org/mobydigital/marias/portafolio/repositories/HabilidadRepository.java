package org.mobydigital.marias.portafolio.repositories;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.entities.Habilidad;

import java.util.List;

public class HabilidadRepository implements CrudRepository<Habilidad>{
    private EntityManager em;

    public HabilidadRepository() {
    }

    public HabilidadRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Habilidad> listar() {
        return em.createQuery("SELECT s FROM Habilidad s", Habilidad.class).getResultList();
    }

    @Override
    public Habilidad porId(Long id) {
        return em.find(Habilidad.class,id);
    }

    @Override
    public void guardar(Habilidad habilidad) {
        if (habilidad.getIdHabilidad() !=null && habilidad.getIdHabilidad() > 0){
            em.merge(habilidad);
        }
        else{
            em.persist(habilidad);
        }
    }

    @Override
    public void eliminar(Long id) {
        Habilidad habilidad = porId(id);
        em.remove(habilidad);
    }
}
