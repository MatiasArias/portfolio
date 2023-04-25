package org.mobydigital.marias.portafolio.repositories;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.entities.Candidato;
import org.mobydigital.marias.portafolio.models.entities.Educacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class CandidatoRepository implements CrudRepository<Candidato>{

    @Autowired
    private EntityManager em;

    public CandidatoRepository() {
    }

    @Override
    public List<Candidato> listar() {
        return em.createQuery("SELECT c FROM Candidato c", Candidato.class).getResultList();
    }

    @Override
    public Candidato porId(Long id) {
        return em.find(Candidato.class,id);
    }

    @Override
    public Candidato guardar(Candidato candidato) {
        if (candidato.getIdCandidato() !=null && candidato.getIdCandidato() > 0){
            em.merge(candidato);
        }
        else{
            em.persist(candidato);
        }
        return candidato;
    }

    @Override
    public void eliminar(Long id) {
        Candidato candidato = porId(id);
        em.remove(candidato);
    }
}
