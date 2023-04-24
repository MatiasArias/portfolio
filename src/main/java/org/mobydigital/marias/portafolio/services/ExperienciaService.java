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
    private ExperienciaRepository repository;


    public List<Experiencia> getListEntidades(String experiencia) {
        if(experiencia!=null){
            return repository.findAll().stream()
                    .filter(e->e.getTitulo().toUpperCase().contains(experiencia.toUpperCase()))
                    .collect(Collectors.toList());
        }else{
            return repository.findAll();
        }
    }


    public Experiencia porId(Long id) {
        return repository.findAll().stream()
                .filter(e->e.getIdExperiencia().equals(id)).findAny()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Experiencia no encontrada"));
    }


    public Experiencia guardar(Experiencia experiencia) {
            repository.save(experiencia);
            return experiencia;
    }


    public void eliminar(Long id) {
        repository.delete(repository.findById(id).get());
    }
}
