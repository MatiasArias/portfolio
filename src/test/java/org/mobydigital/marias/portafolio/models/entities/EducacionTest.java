package org.mobydigital.marias.portafolio.models.entities;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mobydigital.marias.portafolio.exceptions.FechaInvalidaException;
import org.mobydigital.marias.portafolio.repositories.EducacionRepository;
import org.mobydigital.marias.portafolio.services.EducacionService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class EducacionTest {


    @Test
    void testNombreEducacion() {
        Educacion educacion = new Educacion();
        educacion.setTitulo("Testing 2023");
        String real = educacion.getTitulo();
        String esperado = "Testing 2023";
        assertEquals(esperado, real);
    }

    @Test
    void testInstitucionEducacion() {
        Educacion educacion = new Educacion(912L, "UTN FRVM", "Testing 2023", 2023, 2023);
        assertEquals("UTN FRVM", educacion.getInstitucion());
    }

    @Test
    void testIdEducacion() {
        Educacion educacion = new Educacion(912L, "UTN FRVM", "Testing 2023", 2023, 2023);
        assertFalse(educacion.getIdEducacion().compareTo(0L) < 0);
        assertTrue(educacion.getIdEducacion().compareTo(0L) > 0);
    }

    @Test
    void testReferenciaEducacion() {
        Educacion educacion1 = new Educacion(912L, "UTN FRVM", "Testing 2023", 2023, 2023);
        Educacion educacion2 = new Educacion(912L, "UTN FRVM", "Testing 2023", 2023, 2023);
        assertEquals(educacion1, educacion2);
        educacion2.setTitulo("Universidad Tecnologica Nacional - FRVM");
        assertNotEquals(educacion1, educacion2);
    }

    @Test
    void testFechaInvalidaException() {
        Exception exception = assertThrows(FechaInvalidaException.class, () -> {
            Educacion educacion = new Educacion(912L, "UTN FRVM", "Testing 2023", 2028, 2023);
        });
        String actual = exception.getMessage();
        String esperado = "El año de ingreso no puede ser mayor que el año de egreso";
        assertEquals(esperado, actual);
    }

    @Test
    void testRelacionCandidatoEducacion(){
        Candidato candidato = new Candidato(1L,"Matias","Arias","matiasarias384@gmail.com");
        Educacion educacion = new Educacion(912L, "UTN FRVM", "Testing 2023", 2023, 2023, candidato);
        assertEquals("Matias",educacion.getCandidato().getNombre());
        assertNotNull(candidato.getEducacionList());
        assertTrue(candidato.getEducacionList().size()>0);
        assertEquals("UTN FRVM",candidato.getEducacionList().get(0).getInstitucion());
    }
    @ExtendWith(MockitoExtension.class)
    @Nested
    public class UserServiceTest {

        @Mock
        private EducacionRepository educacionRepository;

        @InjectMocks
        private EducacionService educacionService;

        @Test
        void testEducacionUserById() {
            Educacion educacion = new Educacion();
            educacion.setIdEducacion(1L);
            educacion.setInstitucion("UTN FRVM");
            educacion.setTitulo("Testing 2023");
            List<Educacion> lista = new ArrayList<>();
            lista.add(educacion);
            when(educacionRepository.listar()).thenReturn(lista);

            Educacion result = educacionService.porId(1L);

            assertEquals(result, educacion);
            verify(educacionRepository, times(1)).porId(1L);
        }
    }


}