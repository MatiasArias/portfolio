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
    private JpaUtil conexion;
    @Override
    public void init() {
        System.out.println("Nada");
    }

    @Override
    public List getListEntidades(String startWith) {
        List<Proyecto> proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(1L,"Argentina Programa","Argentina Programa - Desarrollador Java Inicial - Rol de Tutor","http://localhost:8080/img/argentina-programa.jpg","https://github.com/MatiasArias/PronosticosDeportivos",new Date()," active"));
        proyectos.add(new Proyecto(2L,"Concesionaria","Trabajo Integrador implementando Java","http://localhost:8080/img/concesionaria.jpg","https://github.com/GIGABYTE-FRVM/Concesionaria",new Date(),""));
        proyectos.add(new Proyecto(3L,"Reinforcement Learning","Implemets SARSA,Qlearning,Dyna-Q","http://localhost:8080/img/qlearning.jpg","https://github.com/MatiasArias/reinforcement-learning",new Date(),""));
        proyectos.add(new Proyecto(4L,"Clock","Primer proyecto Frontend","http://localhost:8080/img/clock.jpg","https://github.com/MatiasArias/reinforcement-learning",new Date(),""));
        return proyectos;
    }
    public List<Proyecto> getListEntidades() {
        List<Proyecto> proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(1L,"Argentina Programa","Argentina Programa - Desarrollador Java Inicial - Rol de Tutor","http://localhost:8080/img/argentina-programa.jpg","https://github.com/MatiasArias/PronosticosDeportivos",new Date()));
        proyectos.add(new Proyecto(2L,"Concesionaria","Trabajo Integrador implementando Java","http://localhost:8080/img/concesionaria.jpg","https://github.com/GIGABYTE-FRVM/Concesionaria",new Date()));
        proyectos.add(new Proyecto(3L,"Reinforcement Learning","Implemets SARSA,Qlearning,Dyna-Q","http://localhost:8080/img/qlearning.jpg","https://github.com/MatiasArias/reinforcement-learning",new Date()));
        proyectos.add(new Proyecto(4L,"Clock","Primer proyecto Frontend","http://localhost:8080/img/clock.jpg","https://github.com/MatiasArias/reinforcement-learning",new Date()));
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
