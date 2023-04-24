package org.mobydigital.marias.portafolio.services;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.entities.Candidato;
import org.mobydigital.marias.portafolio.repositories.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {
    @Autowired
    private EntityManager em;

    @Autowired
    private CrudRepository<Candidato> repository;



    public List<Candidato> getListEntidades(String nombreSubstring) {
        if(nombreSubstring!=null){
            return repository.listar().stream()
                    .filter(c->(c.getNombre()+" "+c.getApellido()).startsWith(nombreSubstring))
                    .collect(Collectors.toList());
        }else{
            return repository.listar();
        }
    }

    public List<Candidato> getListEntidades() {
        return repository.listar();
    }


    public Candidato porId(Long id) {
        return repository.listar().stream().filter(e->e.getIdCandidato().equals(id)).findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Candidato not found"));

    }


    public Candidato guardar(Candidato candidato) {
        if(repository.listar().stream().anyMatch(e -> e.equals(candidato))){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"ese Candidato ya existe");
        }
        try{
            em.getTransaction().begin();
            repository.guardar(candidato);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return candidato;
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
