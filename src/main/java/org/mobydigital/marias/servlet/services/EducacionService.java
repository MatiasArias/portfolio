package org.mobydigital.marias.servlet.services;

import org.mobydigital.marias.servlet.entity.Educacion;

import java.util.List;
import java.util.Optional;

public interface EducacionService {
    List<Educacion> listar();
    Optional<Educacion> porId(Long id);
    void guardar(Educacion educacion);
    void eliminar(Long id);
}
