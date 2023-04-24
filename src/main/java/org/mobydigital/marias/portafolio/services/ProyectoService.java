package org.mobydigital.marias.portafolio.services;

import org.mobydigital.marias.portafolio.models.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ProyectoService {
    @Autowired
    private ArchivoService archivoService;



    public List<Proyecto> getListEntidades() {
        List<Proyecto> proyectos = new ArrayList<>();
        List<String> archivoProyecto = archivoService.leerArchivo("src\\main\\java\\org\\mobydigital\\marias\\portafolio\\files\\Proyectos.csv");
        for(String linea : archivoProyecto){
            System.out.println(linea);
            proyectos.add(new Proyecto(Long.parseLong(linea.split(";")[0]),linea.split(";")[1],linea.split(";")[2],linea.split(";")[3],linea.split(";")[4],new Date(),linea.split(";")[6]));
        }
        return proyectos;
    }


    public Proyecto porId(Long id) {

        return getListEntidades().stream().filter(p->p.getIdProyecto().equals(id)).findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Proyeto no encontrado"));
    }


    public Proyecto guardar(Proyecto proyecto) {
        return null;
    }


    public void eliminar(Long id) {

    }
}
