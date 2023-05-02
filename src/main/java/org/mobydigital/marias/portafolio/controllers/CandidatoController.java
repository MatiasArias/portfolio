package org.mobydigital.marias.portafolio.controllers;



import org.mobydigital.marias.portafolio.models.entities.Candidato;
import org.mobydigital.marias.portafolio.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;
    @PostMapping
    public ResponseEntity<Candidato> guardarCandidato(@RequestBody Candidato candidato){
        return new ResponseEntity<Candidato>(candidatoService.guardar(candidato), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Candidato>> getcandidatos(@RequestParam("educacion") String candidato){
        return new ResponseEntity<List<Candidato>>(candidatoService.getListEntidades(candidato), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Candidato> getCandidatoPorId(@PathVariable("id") Long id){
        return new ResponseEntity<Candidato>(candidatoService.porId(id),HttpStatus.OK);
    }

}
