package org.mobydigital.marias.portafolio.services;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.entities.Educacion;
import org.mobydigital.marias.portafolio.models.Proyecto;
import org.mobydigital.marias.portafolio.repositories.CrudRepository;
import org.mobydigital.marias.portafolio.repositories.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ProyectoService implements EntityService{
    @Autowired
    private JpaUtil conexion;
    @Override
    public void init() {
        System.out.println("Nada");
    }

    @Override
    public List getListEntidades(String startWith) {
        List<Proyecto> proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(1,"Concesionaria","Trabajo Integrador implementando Java","http://localhost:8080/img/concesionaria.jpg","https://github.com/GIGABYTE-FRVM/Concesionaria",new Date()));
        proyectos.add(new Proyecto(2,"Reinforcement Learning","Implemets SARSA,Qlearning,Dyna-Q","http://localhost:8080/img/qlearning.jpg","https://github.com/MatiasArias/reinforcement-learning",new Date()));
        proyectos.add(new Proyecto(3,"Clock","Primer proyecto Frontend","http://localhost:8080/img/clock.jpg","https://github.com/MatiasArias/reinforcement-learning",new Date()));
        return proyectos;
    }

    @Override
    public Object porId(Long id) {
        return null;
    }

    @Override
    public Object guardar(Object o) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
