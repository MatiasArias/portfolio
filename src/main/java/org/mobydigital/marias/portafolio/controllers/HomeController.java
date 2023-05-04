package org.mobydigital.marias.portafolio.controllers;

import org.mobydigital.marias.portafolio.configuration.Pages;
import org.mobydigital.marias.portafolio.services.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProjectServiceImpl projectService;

    @GetMapping("/")
    public ModelAndView getProjects(){
        ModelAndView modelAndView = new ModelAndView(Pages.HOME);
        modelAndView.addObject("projects", projectService.findAll());
        return modelAndView;
    }
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView(Pages.LOGIN);
        return modelAndView;
    }
}
