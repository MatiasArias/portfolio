package org.mobydigital.marias.portafolio.controllers;

import org.mobydigital.marias.portafolio.models.Educacion;
import org.mobydigital.marias.portafolio.services.EducacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/educaciones.json")
public class EducacionController {
    @Autowired
    private EducacionServiceImpl educacionService;

    @GetMapping
    public ResponseEntity<List<Educacion>> getEducaciones(){
        return new ResponseEntity<>(educacionService.getEducaciones(), HttpStatus.OK);
    }
}

