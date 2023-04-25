package org.mobydigital.marias.portafolio.models.entities;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mobydigital.marias.portafolio.repositories.EducacionRepository;
import org.mobydigital.marias.portafolio.services.EducacionService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

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
        educacion.setIdEducacion(1L);
        educacion.setInstitucion("UTN FRVM");
        educacion.setTitulo("Testing 2023");
        List<Educacion> lista = new ArrayList<>();
        lista.add(educacion);
        when(educacionRepository.listar()).thenReturn(lista);

        Educacion result = educacionService.porId(1L);

        assertEquals(result, educacion);
        verify(educacionRepository, times(1)).listar();
    }
}

