package org.mobydigital.marias.portafolio.services;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.entities.Experiencia;
import org.mobydigital.marias.portafolio.repositories.CrudRepository;
import org.mobydigital.marias.portafolio.repositories.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienciaService implements EntityService<Experiencia>{
    private EntityManager em;
    private CrudRepository<Experiencia> repository;
    @Autowired
    private JpaUtil conexion;
    @Override
    @PostConstruct
    public void init() {
        this.em = conexion.getEntityManagerFactory();
        this.repository = new ExperienciaRepository(em);
    }

    @Override
    public List<Experiencia> getListEntidades(String experiencia) {
        if(experiencia!=null){
            return repository.listar().stream()
                    .filter(e->e.getTitulo().toUpperCase().contains(experiencia.toUpperCase()))
                    .collect(Collectors.toList());
        }else{
            return repository.listar();
        }
    }

    @Override
    public Experiencia porId(Long id) {
        return repository.listar().stream()
                .filter(e->e.getIdExperiencia().equals(id)).findAny()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Experiencia no encontrada"));
    }

    @Override
    public Experiencia guardar(Experiencia experiencia) {
        try{
            em.getTransaction().begin();
            repository.guardar(experiencia);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return experiencia;
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
