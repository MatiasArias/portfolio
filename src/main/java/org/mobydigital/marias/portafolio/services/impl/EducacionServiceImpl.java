package org.mobydigital.marias.portafolio.services.impl;



import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.mobydigital.marias.portafolio.models.entities.Educacion;
import org.mobydigital.marias.portafolio.models.views.EducacionDto;
import org.mobydigital.marias.portafolio.repositories.EducacionRepository;
import org.mobydigital.marias.portafolio.services.EducacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EducacionServiceImpl implements EducacionService {

    @Autowired
    private EducacionRepository educacionRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    private static final String ID_NOT_FOUND = "Educacion was not found by id - id: ";
    @Override
    public EducacionDto createEducacion(EducacionDto educacionDto) {
        educacionRepository.save(modelMapper.map(educacionDto, Educacion.class));
        return educacionDto;
    }

    @Override
    public List<EducacionDto> findAll() {
        return educacionRepository.findAll().stream()
                .map(educacion -> modelMapper.map(educacion, EducacionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEducacion(Long id) {
        Optional.ofNullable(getEducacionById(id))
                .ifPresentOrElse(
                        educacion -> educacionRepository.deleteById(id),
                        () -> {
                            log.error(ID_NOT_FOUND + id);
                            throw new EntityNotFoundException(ID_NOT_FOUND + id);
                        }
                );
    }

    @Override
    public EducacionDto getEducacionById(Long id) {
        return educacionRepository.findById(id)
                .map(educacion -> modelMapper.map(educacion, EducacionDto.class))
                .orElseThrow(() -> {
                    log.error(ID_NOT_FOUND + id);
                    return new EntityNotFoundException(ID_NOT_FOUND + id);
                });
    }

    @Override
    public void updateEducacion(Long id, EducacionDto educacionDto) {
        educacionRepository.findById(id)
                .ifPresentOrElse(
                        educacion -> {
                            educacion.setTitulo(educacionDto.getTitulo());
                            educacionRepository.save(educacion);
                        },
                        () -> {
                            log.error(ID_NOT_FOUND + id);
                            throw new EntityNotFoundException(ID_NOT_FOUND + id);
                        }
                );
    }
}
