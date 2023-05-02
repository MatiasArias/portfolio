package org.mobydigital.marias.portafolio.services.impl;



import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.mobydigital.marias.portafolio.models.entities.Education;
import org.mobydigital.marias.portafolio.models.views.EducationDto;
import org.mobydigital.marias.portafolio.repositories.EducationRepository;
import org.mobydigital.marias.portafolio.services.EducationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationRepository educationRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    private static final String ID_NOT_FOUND = "Education was not found by id - id: ";
    @Override
    public EducationDto createEducation(EducationDto educationDto) {
        educationRepository.save(modelMapper.map(educationDto, Education.class));
        return educationDto;
    }

    @Override
    public List<EducationDto> findAll() {
        return educationRepository.findAll().stream()
                .map(education -> modelMapper.map(education, EducationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEducation(Long id) {
        Optional.ofNullable(getEducationById(id))
                .ifPresentOrElse(
                        education -> educationRepository.deleteById(id),
                        () -> {
                            log.error(ID_NOT_FOUND + id);
                            throw new EntityNotFoundException(ID_NOT_FOUND + id);
                        }
                );
    }

    @Override
    public EducationDto getEducationById(Long id) {
        return educationRepository.findById(id)
                .map(education -> modelMapper.map(education, EducationDto.class))
                .orElseThrow(() -> {
                    log.error(ID_NOT_FOUND + id);
                    return new EntityNotFoundException(ID_NOT_FOUND + id);
                });
    }

    @Override
    public void updateEducation(Long id, EducationDto educationDto) {
        educationRepository.findById(id)
                .ifPresentOrElse(
                        education -> {
                            education.setDegree(educationDto.getDegree());
                            educationRepository.save(education);
                        },
                        () -> {
                            log.error(ID_NOT_FOUND + id);
                            throw new EntityNotFoundException(ID_NOT_FOUND + id);
                        }
                );
    }
}
