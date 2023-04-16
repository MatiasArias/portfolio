package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;
@GetMapping("/")
    public String getProyectos(Model model) {
    model.addAttribute("proyectos", proyectoService.getListEntidades(""));
    return "index";
}
}
