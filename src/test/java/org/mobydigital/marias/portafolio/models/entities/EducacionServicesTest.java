package org.mobydigital.marias.portafolio.models.entities;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mobydigital.marias.portafolio.models.views.EducacionDto;
import org.mobydigital.marias.portafolio.repositories.EducacionRepository;
import org.mobydigital.marias.portafolio.services.EducacionService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    private EducacionService educacionService;

    @Test
    void testEducacionById() {
        Educacion educacion = new Educacion();
        educacion.setInstitucion("UTN FRVM");
        educacion.setTitulo("Testing 2023");
        when(educacionRepository.findById(1L)).thenReturn(Optional.of(educacion));

        EducacionDto result = educacionService.getEducacionById(1L);

        assertEquals(result.getInstitucion(), educacion.getInstitucion());
        verify(educacionRepository, times(1)).findById(1L);
    }
}

