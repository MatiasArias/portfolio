package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.configuration.Pages;
import org.mobydigital.marias.portafolio.models.entities.Skill;
import org.mobydigital.marias.portafolio.models.views.ExperienceDto;
import org.mobydigital.marias.portafolio.models.views.SkillDto;
import org.mobydigital.marias.portafolio.services.impl.SkillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillServiceImpl skillService;

    @GetMapping
    public ResponseEntity<List<SkillDto>> getSkills(){
        return new ResponseEntity<List<SkillDto>>(skillService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<SkillDto> getSkillById(@PathVariable("id") Long id){
        return new ResponseEntity<SkillDto>(skillService.getSkillById(id),HttpStatus.OK);
    }

    @GetMapping("/form")
    public ModelAndView createSkillView(){
        ModelAndView modelAndView = new ModelAndView(Pages.FORM_SKILL);
        modelAndView.addObject("id",0);
        modelAndView.addObject("action","Save");
        return modelAndView.addObject("skill",new SkillDto());
    }
    @PostMapping("/form")
    public RedirectView createSkillForm(SkillDto skill, Model model){
        skillService.createSkill(skill);
        model.addAttribute("skills",skillService.findAll());
        return new RedirectView("/skills");
    }
    @GetMapping("/form/{id}")
    public ModelAndView updateSkillView(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView(Pages.FORM_SKILL);
        modelAndView.addObject("id",id);
        modelAndView.addObject("action","Update");
        return modelAndView.addObject("skill",skillService.getSkillById(id));
    }
    @PostMapping("/form/{id}")
    public RedirectView updateSkillForm(@PathVariable("id") Long id,SkillDto skill, Model model){
        skillService.updateSkill(id,skill);
        model.addAttribute("skills",skillService.findAll());
        return new RedirectView("/skills");
    }
    @PostMapping("/create")
    public ResponseEntity<Object> createSkill(SkillDto skill, Model model){
        skillService.createSkill(skill);
        model.addAttribute("habilidades",skillService.findAll());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/update/id")
    public ResponseEntity<Void> updateSkill(@PathVariable("id") Long id, @RequestBody SkillDto skill){
        skillService.updateSkill(id,skill);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable("id") Long id){
        skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
