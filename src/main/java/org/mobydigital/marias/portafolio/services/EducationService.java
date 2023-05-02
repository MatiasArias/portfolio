package org.mobydigital.marias.portafolio.services;


import org.mobydigital.marias.portafolio.models.views.EducationDto;

import java.util.List;

public interface EducationService {
    EducationDto createEducation(EducationDto educationDto);

    List<EducationDto> findAll();

    void deleteEducation(Long id);

    EducationDto getEducationById(Long id);

    void updateEducation(Long id, EducationDto educationDto);
}
