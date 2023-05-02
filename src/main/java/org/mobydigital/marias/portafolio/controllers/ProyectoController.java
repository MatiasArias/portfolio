package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.configuration.Pages;
import org.mobydigital.marias.portafolio.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

@GetMapping("/p/{proyecto}")
    public ModelAndView getProyectoIndividual(
             @PathVariable(required=true,name="proyecto") Long id){
    ModelAndView modelAndView = new ModelAndView(Pages.PROYECTO);
    modelAndView.addObject("proyecto",proyectoService.porId(id));
    return modelAndView;
}
@GetMapping("")
    public ModelAndView getProyectoIndividualRequest(
            @RequestParam(defaultValue="1",name = "id",required = false) Long id){
    ModelAndView modelAndView = new ModelAndView(Pages.PROYECTO);
    modelAndView.addObject("proyecto",proyectoService.porId(id));
    return modelAndView;
}


}
