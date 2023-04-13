package org.mobydigital.marias.portafolio.services;


import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.Educacion;
import org.mobydigital.marias.servlet.repositories.CrudRepository;
import org.mobydigital.marias.servlet.repositories.EducacionRepository;
import org.mobydigital.marias.portafolio.services.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducacionServiceImpl implements EducacionService{

    private EntityManager em;
    private CrudRepository<Educacion> repository;
    @Autowired
    private JpaUtil conexion;
    
    @PostConstruct
    public void init(){
        this.em = conexion.getEntityManagerFactory();
        this.repository = new EducacionRepository(em);
    }
    public List<Educacion> getEducaciones() {
        return repository.listar();
    }

    @Override
    public Optional<Educacion> porId(Long id) {return Optional.ofNullable(repository.porId(id));}

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
