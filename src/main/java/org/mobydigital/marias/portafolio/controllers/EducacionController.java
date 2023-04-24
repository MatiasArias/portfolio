package org.mobydigital.marias.portafolio.controllers;

import jakarta.ws.rs.QueryParam;
import org.mobydigital.marias.portafolio.models.views.EducacionDto;
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
    public ResponseEntity<List<EducacionDto>> getEducaciones(@QueryParam("educacion") String educacion){
        return new ResponseEntity<List<EducacionDto>>(educacionService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<EducacionDto> getEducacionPorId(@PathVariable("id") Long id){
        return new ResponseEntity<EducacionDto>(educacionService.getEducacionById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EducacionDto> guardarEducacion(@RequestBody EducacionDto educacion){
        return new ResponseEntity<EducacionDto>(educacionService.createEducacion(educacion),HttpStatus.CREATED);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Object> actualizarEducacion(@PathVariable Long id,@RequestBody EducacionDto educacion){
        educacionService.updateEducacion(id,educacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id){
        educacionService.deleteEducacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

