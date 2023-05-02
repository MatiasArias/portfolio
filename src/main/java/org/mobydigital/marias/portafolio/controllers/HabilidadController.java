package org.mobydigital.marias.portafolio.controllers;


import org.mobydigital.marias.portafolio.configuration.Pages;
import org.mobydigital.marias.portafolio.models.entities.Habilidad;
import org.mobydigital.marias.portafolio.services.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {
    @Autowired
    private HabilidadService habilidadService;

    @GetMapping
    public ResponseEntity<List<Habilidad>> getHabilidades(@RequestParam("habilidad") String habilidad){
        return new ResponseEntity<List<Habilidad>>(habilidadService.getListEntidades(habilidad), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Habilidad> gethabilidadPorId(@PathVariable("id") Long id){
        return new ResponseEntity<Habilidad>(habilidadService.porId(id),HttpStatus.OK);
    }

    @GetMapping("/cargarHabilidad")
    public ModelAndView cargarHabilidadView(){
        ModelAndView modelAndView = new ModelAndView(Pages.CARGAR_HABILIDAD);
        return modelAndView.addObject("habilidad",new Habilidad());
    }
    @PostMapping("/cargarHabilidad")
    public String cargarHabilidadPost(Habilidad habilidad, Model model){
        habilidadService.guardar(habilidad);
        model.addAttribute("habilidades",habilidadService.getListEntidades(""));
        return "index";
    }
    @PostMapping
    public ResponseEntity<Habilidad> guardarHabilidad(@RequestBody Habilidad habilidad){
        return new ResponseEntity<Habilidad>(habilidadService.guardar(habilidad),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Habilidad> actualizarHabilidad(@RequestBody Habilidad habilidad){
        return new ResponseEntity<Habilidad>(habilidadService.guardar(habilidad),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHabilidad(@PathVariable("id") Long id){
        habilidadService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
