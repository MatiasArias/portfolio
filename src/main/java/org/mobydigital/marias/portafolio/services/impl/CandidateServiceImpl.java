package org.mobydigital.marias.portafolio.services;

import org.mobydigital.marias.portafolio.models.entities.Candidate;
import org.mobydigital.marias.portafolio.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {

    @Autowired
    private CandidateRepository repository;

    public List<Candidate> getListEntidades(String nombreSubstring) {
        if(nombreSubstring!=null){
            return repository.findAll().stream()
                    .filter(c->(c.getName()+" "+c.getLastname()).startsWith(nombreSubstring))
                    .collect(Collectors.toList());
        }else{
            return repository.findAll();
        }
    }

    public List<Candidate> getListEntidades() {
        return repository.findAll();
    }


    public Candidate porId(Long id) {
        return repository.findAll().stream().filter(e->e.getIdCandidate().equals(id)).findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Candidato not found"));

    }


    public Candidate guardar(Candidate candidato) {
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
