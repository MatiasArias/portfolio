package org.mobydigital.marias.portafolio.services;


import org.mobydigital.marias.portafolio.models.views.EducacionDto;

import java.util.List;

public interface EducacionService {
    EducacionDto createEducacion(EducacionDto educacionDto);

    List<EducacionDto> findAll();

    void deleteEducacion(Long id);

    EducacionDto getEducacionById(Long id);

    void updateEducacion(Long id, EducacionDto educacionDto);
}
