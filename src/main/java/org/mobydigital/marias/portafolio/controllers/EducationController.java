package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.configuration.Pages;
import org.mobydigital.marias.portafolio.models.views.EducationDto;
import org.mobydigital.marias.portafolio.models.views.ExperienceDto;
import org.mobydigital.marias.portafolio.models.views.SkillDto;
import org.mobydigital.marias.portafolio.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    @GetMapping("/form")
    public ModelAndView createEducationView(){
        ModelAndView modelAndView = new ModelAndView(Pages.FORM_EDUCATION);
        modelAndView.addObject("id",0);
        modelAndView.addObject("action","Save");
        return modelAndView.addObject("education",new EducationDto());
    }
    @PostMapping("/form")
    public RedirectView saveEducationForm(EducationDto education, Model model){
        educationService.createEducation(education);
        model.addAttribute("educations",educationService.findAll());
        return new RedirectView("/educations");
    }
    @GetMapping("/form/{id}")
    public ModelAndView updateSkillView(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView(Pages.FORM_EDUCATION);
        modelAndView.addObject("id",id);
        modelAndView.addObject("action","Update");
        return modelAndView.addObject("education",educationService.getEducationById(id));
    }
    @PostMapping("/form/{id}")
    public RedirectView updateSkillForm(@PathVariable("id") Long id, EducationDto educationDto, Model model){
        educationService.updateEducation(id,educationDto);
        model.addAttribute("educations",educationService.findAll());
        return new RedirectView("/educations");
    }

    @PostMapping("/create")
    public ResponseEntity<EducationDto> createEducation(@RequestBody EducationDto education){
        return new ResponseEntity<EducationDto>(educationService.createEducation(education),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEducation(@PathVariable Long id,@RequestBody EducationDto education){
        educationService.updateEducation(id,education);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEducation(@PathVariable("id") Long id){
        educationService.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

