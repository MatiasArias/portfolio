package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.configuration.Pages;
import org.mobydigital.marias.portafolio.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

@GetMapping("/")
    public ModelAndView getProyectos(){
    ModelAndView modelAndView = new ModelAndView(Pages.HOME);
    modelAndView.addObject("proyectos", proyectoService.getListEntidades(""));
    return modelAndView;
}
@GetMapping("/proyecto")
    public ModelAndView getProyectoIndividual(
            @RequestParam(defaultValue = "1",name = "id",required = false) Long id
    ){
    ModelAndView modelAndView = new ModelAndView(Pages.PROYECTO);
    modelAndView.addObject("proyecto",proyectoService.porId(id));
    return modelAndView;
}


}
