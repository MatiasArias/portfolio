package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.configuration.Pages;
import org.mobydigital.marias.portafolio.services.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectServiceImpl projectService;

@GetMapping("/p/{project}")
    public ModelAndView getProject(
             @PathVariable(required=true,name= "project") Long id){
    ModelAndView modelAndView = new ModelAndView(Pages.PROJECT);
    modelAndView.addObject("project", projectService.getProjectById(id));
    return modelAndView;
}
@GetMapping("")
    public ModelAndView getProjectRequest(
            @RequestParam(defaultValue="1",name = "id",required = false) Long id){
    ModelAndView modelAndView = new ModelAndView(Pages.PROJECT);
    modelAndView.addObject("project", projectService.getProjectById(id));
    return modelAndView;
}


}
