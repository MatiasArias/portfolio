package org.mobydigital.marias.servlet.services;

import org.mobydigital.marias.portafolio.entities.Educacion;

import java.util.List;
import java.util.Optional;

public interface EducacionService {
    List<Educacion> getEducaciones();
    Optional<Educacion> porId(Long id);
    void guardar(Educacion educacion);
    void eliminar(Long id);
}
