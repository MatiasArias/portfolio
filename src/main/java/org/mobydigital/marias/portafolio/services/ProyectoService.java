package org.mobydigital.marias.portafolio.services;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.entities.Educacion;
import org.mobydigital.marias.portafolio.models.Proyecto;
import org.mobydigital.marias.portafolio.repositories.CrudRepository;
import org.mobydigital.marias.portafolio.repositories.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ProyectoService implements EntityService<Proyecto>{
    @Autowired
    private ArchivoService archivoService;
    @Override
    public void init() {
        System.out.println("Nada");
    }

    @Override
    public List getListEntidades(String startWith) {
        List<Proyecto> proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(0L,"Argentina Programa","Argentina Programa - Desarrollador Java Inicial - Rol de Tutor","http://localhost:8080/img/argentina-programa.jpg","https://github.com/MatiasArias/PronosticosDeportivos",new Date()," active"));
        proyectos.add(new Proyecto(1L,"Concesionaria","Trabajo Integrador implementando Java","http://localhost:8080/img/concesionaria.jpg","https://github.com/GIGABYTE-FRVM/Concesionaria",new Date(),""));
        proyectos.add(new Proyecto(2L,"Reinforcement Learning","Implemets SARSA,Qlearning,Dyna-Q","http://localhost:8080/img/qlearning.jpg","https://github.com/MatiasArias/reinforcement-learning",new Date(),""));
        proyectos.add(new Proyecto(3L,"Clock","Primer proyecto Frontend","http://localhost:8080/img/clock.jpg","https://github.com/MatiasArias/reinforcement-learning",new Date(),""));
        return proyectos;
    }

    public List<Proyecto> getListEntidades() {
        List<Proyecto> proyectos = new ArrayList<>();
        List<String> archivoProyecto = archivoService.leerArchivo("C:\\Users\\Usuario\\Desktop\\WORK\\MobyDigital\\Academy\\portafolio\\src\\main\\java\\org\\mobydigital\\marias\\portafolio\\files\\Proyectos.csv");
        for(String linea : archivoProyecto){
            System.out.println(linea);
            proyectos.add(new Proyecto(Long.parseLong(linea.split(";")[0]),linea.split(";")[1],linea.split(";")[2],linea.split(";")[3],linea.split(";")[4],new Date(),linea.split(";")[6]));
        }
        return proyectos;
    }

    @Override
    public Proyecto porId(Long id) {

        return getListEntidades().stream().filter(p->p.getIdProyecto().equals(id)).findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Proyeto no encontrado"));
    }

    @Override
    public Proyecto guardar(Proyecto proyecto) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
