package org.mobydigital.marias.portafolio.repositories;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.entities.Educacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EducacionRepository implements CrudRepository<Educacion> {

    @Autowired
    private EntityManager em;

    public EducacionRepository() {

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
