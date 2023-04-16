package org.mobydigital.marias.portafolio.controllers;

import jakarta.ws.rs.QueryParam;
import org.mobydigital.marias.portafolio.entities.Habilidad;
import org.mobydigital.marias.portafolio.services.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {
    @Autowired
    private HabilidadService habilidadService;

    @GetMapping
    public ResponseEntity<List<Habilidad>> getHabilidades(@QueryParam("habilidad") String habilidad){
        return new ResponseEntity<List<Habilidad>>(habilidadService.getListEntidades(habilidad), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Habilidad> gethabilidadPorId(@PathVariable("id") Long id){
        return new ResponseEntity<Habilidad>(habilidadService.porId(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Habilidad> guardarHabilidad(@RequestBody Habilidad habilidad){
        return new ResponseEntity<Habilidad>(habilidadService.guardar(habilidad),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Habilidad> actualizarHabilidad(@RequestBody Habilidad habilidad){
        return new ResponseEntity<Habilidad>(habilidadService.guardar(habilidad),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHabilidad(@PathVariable("id") Long id){
        habilidadService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
