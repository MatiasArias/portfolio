package org.mobydigital.marias.portafolio.controllers;

import jakarta.ws.rs.QueryParam;
import org.mobydigital.marias.portafolio.models.Educacion;
import org.mobydigital.marias.portafolio.services.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educaciones")
public class EducacionController {
    @Autowired
    private EducacionService educacionService;

    @GetMapping
    public ResponseEntity<List<Educacion>> getEducaciones(@QueryParam("educacion") String educacion){
        return new ResponseEntity<List<Educacion>>(educacionService.getListEntidades(educacion), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Educacion> getEducacionPorId(@PathVariable("id") Long id){
        return new ResponseEntity<Educacion>(educacionService.porId(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Educacion> guardarEducacion(@RequestBody Educacion educacion){
        return new ResponseEntity<Educacion>(educacionService.guardar(educacion),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Educacion> actualizarEducacion(@RequestBody Educacion educacion){
        return new ResponseEntity<Educacion>(educacionService.guardar(educacion),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        educacionService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

