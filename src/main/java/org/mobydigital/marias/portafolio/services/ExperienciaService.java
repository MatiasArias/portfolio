package org.mobydigital.marias.portafolio.services;

import jakarta.persistence.EntityManager;
import org.mobydigital.marias.portafolio.models.Experiencia;
import org.mobydigital.marias.portafolio.repositories.CrudRepository;
import org.mobydigital.marias.portafolio.repositories.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienciaService implements EntityService<Experiencia>{
    private EntityManager em;
    private CrudRepository<Experiencia> repository;
    @Autowired
    private JpaUtil conexion;
    @Override
    public void init() {
        this.repository = new ExperienciaRepository(conexion.getEntityManagerFactory());
    }

    @Override
    public List<Experiencia> getListEntidades(String experiencia) {
        if(experiencia!=null){
            return repository.listar().stream()
                    .filter(e->e.getTitulo().contains(experiencia))
                    .collect(Collectors.toList());
        }else{
            return repository.listar();
        }
    }

    @Override
    public Experiencia porId(Long id) {
        return repository.listar().stream()
                .filter(e->e.getIdExperiencia().equals(id)).findAny()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Experiencia no encontrada"));
    }

    @Override
    public Experiencia guardar(Experiencia experiencia) {
        if(repository.listar().stream().anyMatch(e -> e.equals(experiencia))){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"esa Experiencia ya existe");
        }
        try{
            em.getTransaction().begin();
            repository.guardar(experiencia);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return experiencia;
    }

    @Override
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
