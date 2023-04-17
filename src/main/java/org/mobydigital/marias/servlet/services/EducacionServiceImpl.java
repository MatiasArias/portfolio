package org.mobydigital.marias.servlet.services;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.entities.Educacion;
import org.mobydigital.marias.portafolio.repositories.CrudRepository;
import org.mobydigital.marias.portafolio.repositories.EducacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EducacionServiceImpl implements EducacionService {
    private EntityManager em;
    private CrudRepository<Educacion> repository;

    public EducacionServiceImpl() {
    }

    public EducacionServiceImpl(EntityManager em) {
        this.em = em;
        this.repository = new EducacionRepository(em);
    }

    @Override
    public List<Educacion> getEducaciones() {
        return repository.listar();
    }

    @Override
    public Optional<Educacion> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Educacion educacion) {
    try{
em.getTransaction().begin();
repository.guardar(educacion);
em.getTransaction().commit();
    }catch(Exception e){
        em.getTransaction().rollback();
        e.printStackTrace();
    }
    }

    @Override
    public void eliminar(Long id) {
        try{
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
