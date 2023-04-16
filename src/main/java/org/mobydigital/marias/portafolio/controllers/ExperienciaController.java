package org.mobydigital.marias.portafolio.controllers;

import jakarta.ws.rs.QueryParam;
import org.mobydigital.marias.portafolio.entities.Experiencia;
import org.mobydigital.marias.portafolio.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencias")
public class ExperienciaController {
    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping
    public ResponseEntity<List<Experiencia>> getExperiencias(@QueryParam("experiencia") String experiencia){
        return new ResponseEntity<List<Experiencia>>(experienciaService.getListEntidades(experiencia), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Experiencia> getExperienciaPorId(@PathVariable("id") Long id){
        return new ResponseEntity<Experiencia>(experienciaService.porId(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Experiencia> guardarExperiencia(@RequestBody Experiencia experiencia){
        return new ResponseEntity<Experiencia>(experienciaService.guardar(experiencia),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Experiencia> actualizarExperiencia(@RequestBody Experiencia experiencia){
        return new ResponseEntity<Experiencia>(experienciaService.guardar(experiencia),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        experienciaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
