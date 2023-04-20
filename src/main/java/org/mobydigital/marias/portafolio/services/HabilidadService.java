package org.mobydigital.marias.portafolio.services;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.entities.Habilidad;
import org.mobydigital.marias.portafolio.repositories.CrudRepository;
import org.mobydigital.marias.portafolio.repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabilidadService implements EntityService<Habilidad> {

    @Autowired
    private EntityManager em;
    @Autowired
    private CrudRepository<Habilidad> repository;


    @Override
    public List<Habilidad> getListEntidades(String startWith) {
        if(startWith!=null){
            return repository.listar().stream()
                    .filter(s->s.getTitulo().toUpperCase().contains(startWith.toUpperCase()))
                    .collect(Collectors.toList());
        }else{
            return repository.listar();
        }
    }

    @Override
    public Habilidad porId(Long id) {
        return repository.listar().stream().filter(s->s.getIdHabilidad().equals(id)).findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Habilidad not found"));

    }

    @Override
    public Habilidad guardar(Habilidad habilidad) {
        if(!habilidad.getTitulo().isEmpty()){
        try{
            em.getTransaction().begin();
            repository.guardar(habilidad);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        }
        return habilidad;
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
