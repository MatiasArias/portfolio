package org.mobydigital.marias.portafolio.services;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.entities.Experiencia;
import org.mobydigital.marias.portafolio.repositories.CrudRepository;
import org.mobydigital.marias.portafolio.repositories.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienciaService {
    @Autowired
    private EntityManager em;
    @Autowired
    private CrudRepository<Experiencia> repository;


    public List<Experiencia> getListEntidades(String experiencia) {
        if(experiencia!=null){
            return repository.listar().stream()
                    .filter(e->e.getTitulo().toUpperCase().contains(experiencia.toUpperCase()))
                    .collect(Collectors.toList());
        }else{
            return repository.listar();
        }
    }


    public Experiencia porId(Long id) {
        return repository.listar().stream()
                .filter(e->e.getIdExperiencia().equals(id)).findAny()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Experiencia no encontrada"));
    }


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
