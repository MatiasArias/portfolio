package org.mobydigital.marias.portafolio.controllers;

import org.mobydigital.marias.portafolio.configuration.Pages;
import org.mobydigital.marias.portafolio.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/")
    public ModelAndView getProyectos(){
        ModelAndView modelAndView = new ModelAndView(Pages.HOME);
        modelAndView.addObject("proyectos", proyectoService.getListEntidades(""));
        return modelAndView;
    }
}
