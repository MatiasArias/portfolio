package org.mobydigital.marias.portafolio.services;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mobydigital.marias.portafolio.models.entities.Educacion;
import org.mobydigital.marias.portafolio.models.views.EducacionDto;
import org.mobydigital.marias.portafolio.repositories.EducacionRepository;
import org.mobydigital.marias.portafolio.services.EducacionService;
import org.mobydigital.marias.portafolio.services.impl.EducacionServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EducacionServicesTest {

    @Mock
    private EducacionRepository educacionRepository;

    @InjectMocks
    private EducacionServiceImpl educacionService;

    @Test
    void testEducacionById() {
        Educacion educacion = new Educacion();
        educacion.setInstitucion("UTN FRVM");
        educacion.setTitulo("Testing 2023");
        when(educacionRepository.findById(1L)).thenReturn(Optional.of(educacion));

        EducacionDto result = educacionService.getEducacionById(1L);

        assertEquals(result.getInstitucion(), educacion.getInstitucion());
        assertEquals(result.getTitulo(), educacion.getTitulo());
        verify(educacionRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateEducacion() {
        Educacion educacion = new Educacion();
        educacion.setInstitucion("UTN FRVM");
        educacion.setTitulo("Testing");

        when(educacionRepository.save(educacion)).thenReturn(educacion);

        EducacionDto educacionDTO = new EducacionDto();
        educacionDTO.setInstitucion("UTN FRVM");
        educacionDTO.setTitulo("Testing");

        EducacionDto result = educacionService.createEducacion(educacionDTO);

        assertEquals(result.getInstitucion(), educacion.getInstitucion());
        assertEquals(result.getTitulo(), educacion.getTitulo());
        verify(educacionRepository, times(1)).save(educacion);
    }
}

