package org.mobydigital.marias.portafolio.services;

import org.mobydigital.marias.portafolio.models.views.ExperienceDto;

import java.util.List;

public interface ExperienceService {
    ExperienceDto createExperience(ExperienceDto experiencedto);

    List<ExperienceDto> findAll();

    void deleteExperience(Long id);

    ExperienceDto getExperienceById(Long id);

    void updateExperience(Long id, ExperienceDto experienceDto);
}
