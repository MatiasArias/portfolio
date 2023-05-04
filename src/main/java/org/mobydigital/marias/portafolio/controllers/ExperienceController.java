package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.configuration.Pages;
import org.mobydigital.marias.portafolio.models.entities.Skill;
import org.mobydigital.marias.portafolio.models.views.ExperienceDto;
import org.mobydigital.marias.portafolio.models.views.SkillDto;
import org.mobydigital.marias.portafolio.services.impl.ExperienceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    @GetMapping("/form")
    public ModelAndView createExperienceView(){
        ModelAndView modelAndView = new ModelAndView(Pages.FORM_EXPERIENCE);
        modelAndView.addObject("id",0);
        modelAndView.addObject("action","Save");
        return modelAndView.addObject("experience",new ExperienceDto());
    }
    @PostMapping("/form")
    public RedirectView saveExperienceForm(ExperienceDto experience, Model model){
        experienceService.createExperience(experience);
        model.addAttribute("experiences",experienceService.findAll());
        return new RedirectView("/experiences");
    }
    @GetMapping("/form/{id}")
    public ModelAndView updateSkillView(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView(Pages.FORM_EXPERIENCE);
        modelAndView.addObject("idExperience",id);
        modelAndView.addObject("action","Update");
        return modelAndView.addObject("experience",experienceService.getExperienceById(id));
    }
    @PostMapping("/form/{id}")
    public RedirectView updateSkillForm(@PathVariable("id") Long id, ExperienceDto experienceDto, Model model){
        experienceService.updateExperience(id,experienceDto);
        model.addAttribute("experiences",experienceService.findAll());
        return new RedirectView("/experiences");
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
