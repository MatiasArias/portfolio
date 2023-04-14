package org.mobydigital.marias.portafolio.services;


import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.Educacion;
import org.mobydigital.marias.portafolio.repositories.CrudRepository;
import org.mobydigital.marias.portafolio.repositories.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducacionServiceImpl{

    private EntityManager em;
    private CrudRepository<Educacion> repository;
    @Autowired
    private JpaUtil conexion;

    @PostConstruct
    public void init(){
        this.em = conexion.getEntityManagerFactory();
        this.repository = new EducacionRepository(em);
    }
    public List<Educacion> getEducaciones(String startWith) {
        if(startWith!=null){
        return repository.listar().stream()
                .filter(e->e.getTitulo().startsWith(startWith))
                .collect(Collectors.toList());
        }else{
        return repository.listar();
        }
    }


    public Educacion porId(Long id) {
        return repository.listar().stream().filter(e->e.getIdEducacion().equals(id)).findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Educacion not found"));
    }


    public Educacion guardar(Educacion educacion) {
        if(repository.listar().stream().anyMatch(e -> e.equals(educacion))){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"esa Educacion ya existe");
        }
        try{
            em.getTransaction().begin();
            repository.guardar(educacion);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return educacion;
    }


    public void eliminar(Long id) {
        try{
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
