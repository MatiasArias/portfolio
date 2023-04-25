package org.mobydigital.marias.portafolio.services;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.entities.Candidato;
import org.mobydigital.marias.portafolio.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository repository;

    public List<Candidato> getListEntidades(String nombreSubstring) {
        if(nombreSubstring!=null){
            return repository.findAll().stream()
                    .filter(c->(c.getNombre()+" "+c.getApellido()).startsWith(nombreSubstring))
                    .collect(Collectors.toList());
        }else{
            return repository.findAll();
        }
    }

    public List<Candidato> getListEntidades() {
        return repository.findAll();
    }


    public Candidato porId(Long id) {
        return repository.findAll().stream().filter(e->e.getIdCandidato().equals(id)).findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Candidato not found"));

    }


    public Candidato guardar(Candidato candidato) {
        if(repository.findAll().stream().anyMatch(e -> e.equals(candidato))){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"ese Candidato ya existe");
        }
            repository.save(candidato);
        return candidato;
    }


    public void eliminar(Long id) {
            repository.delete(repository.findById(id).get());
    }
}
