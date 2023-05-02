package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.models.views.ExperienceDto;
import org.mobydigital.marias.portafolio.services.impl.ExperienceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    @Autowired
    private ExperienceServiceImpl experienceService;

    @GetMapping
    public ResponseEntity<List<ExperienceDto>> getExperiences(){
        return new ResponseEntity<List<ExperienceDto>>(experienceService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ExperienceDto> getExperiencePorId(@PathVariable("id") Long id){
        return new ResponseEntity<ExperienceDto>(experienceService.getExperienceById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ExperienceDto> saveExperience(@RequestBody ExperienceDto experience){
        return new ResponseEntity<ExperienceDto>(experienceService.createExperience(experience),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateExperience(@PathVariable Long id, @RequestBody ExperienceDto experience){
        experienceService.updateExperience(id,experience);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        experienceService.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
