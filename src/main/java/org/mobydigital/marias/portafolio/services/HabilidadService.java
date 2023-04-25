package org.mobydigital.marias.portafolio.services;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.entities.Habilidad;
import org.mobydigital.marias.portafolio.repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabilidadService {

    @Autowired
    private HabilidadRepository repository;



    public List<Habilidad> getListEntidades(String startWith) {
        System.out.println(repository.findAll());
        if(startWith!=null){
            return repository.findAll().stream()
                    .filter(s->s.getTitulo().toUpperCase().contains(startWith.toUpperCase()))
                    .collect(Collectors.toList());
        }else{
            return repository.findAll();
        }
    }


    public Habilidad porId(Long id) {
        return repository.findAll().stream().filter(s->s.getIdHabilidad().equals(id)).findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Habilidad not found"));

    }


    public Habilidad guardar(Habilidad habilidad) {
        if(!habilidad.getTitulo().isEmpty()){
            repository.save(habilidad);
        }
        return habilidad;
    }


    public void eliminar(Long id) {
        repository.delete(repository.findById(id).get());
    }
}
