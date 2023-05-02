package org.mobydigital.marias.portafolio.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.mobydigital.marias.portafolio.models.entities.Experience;
import org.mobydigital.marias.portafolio.models.views.ExperienceDto;
import org.mobydigital.marias.portafolio.repositories.ExperienceRepository;
import org.mobydigital.marias.portafolio.services.ExperienceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository repository;

    private final ModelMapper modelMapper = new ModelMapper();

    private static final String ID_NOT_FOUND = "Experience was not found by id - id: ";

    @Override
    public ExperienceDto createExperience(ExperienceDto experiencedto) {
        repository.save(modelMapper.map(experiencedto,Experience.class));
        return experiencedto;
    }

    @Override
    public List<ExperienceDto> findAll() {
        return repository.findAll().stream()
                .map(experience -> modelMapper.map(experience, ExperienceDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteExperience(Long id) {
        Optional.ofNullable(getExperienceById(id)).ifPresentOrElse(
                experience -> repository.deleteById(id),
                () -> {
                    log.error(ID_NOT_FOUND + id);
                    throw new EntityNotFoundException(ID_NOT_FOUND + id);
                }
        );
    }

    @Override
    public ExperienceDto getExperienceById(Long id) {
        return repository.findById(id).map(
                        experience -> modelMapper.map(experience, ExperienceDto.class))
                .orElseThrow(() -> {
                    log.error(ID_NOT_FOUND + id);
                    return new EntityNotFoundException(ID_NOT_FOUND + id);
                });
    }

    @Override
    public void updateExperience(Long id, ExperienceDto experienceDto) {
        repository.findById(id).ifPresentOrElse(
                experience -> {
                    experience.setName(experienceDto.getName());
                    experience.setDescription(experienceDto.getDescription());
                    experience.setYearSince(experienceDto.getYearSince());
                    experience.setYearUntil(experienceDto.getYearUntil());
                    repository.save(experience);
                }, () -> {
                    log.error(ID_NOT_FOUND);
                    throw new EntityNotFoundException(ID_NOT_FOUND + id);
                }
        );
    }
}
