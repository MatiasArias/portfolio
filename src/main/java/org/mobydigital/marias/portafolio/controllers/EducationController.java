package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.models.views.EducationDto;
import org.mobydigital.marias.portafolio.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educations")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping
    public ResponseEntity<List<EducationDto>> getEducations(){
        return new ResponseEntity<List<EducationDto>>(educationService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<EducationDto> getEducationPorId(@PathVariable("id") Long id){
        return new ResponseEntity<EducationDto>(educationService.getEducationById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EducationDto> guardarEducacion(@RequestBody EducationDto education){
        return new ResponseEntity<EducationDto>(educationService.createEducation(education),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEducation(@PathVariable Long id,@RequestBody EducationDto education){
        educationService.updateEducation(id,education);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id){
        educationService.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

