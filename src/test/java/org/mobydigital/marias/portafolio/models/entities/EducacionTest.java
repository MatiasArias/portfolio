package org.mobydigital.marias.portafolio.models.entities;

import org.junit.jupiter.api.Test;
import org.mobydigital.marias.portafolio.exceptions.FechaInvalidaException;

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
        Educacion educacion = new Educacion(912L, "UTN FRVM", "Testing 2023", 2023, 2023, null);
        assertEquals("UTN FRVM", educacion.getInstitucion());
    }

    @Test
    void testIdEducacion() {
        Educacion educacion = new Educacion(912L, "UTN FRVM", "Testing 2023", 2023, 2023, null);
        assertFalse(educacion.getIdEducacion().compareTo(0L) < 0);
        assertTrue(educacion.getIdEducacion().compareTo(0L) > 0);
    }

    @Test
    void testReferenciaEducacion() {
        Educacion educacion1 = new Educacion(912L, "UTN FRVM", "Testing 2023", 2023, 2023, null);
        Educacion educacion2 = new Educacion(912L, "UTN FRVM", "Testing 2023", 2023, 2023, null);
        assertEquals(educacion1, educacion2);
    }

    @Test
    void FechaInvalidaException() {
        Exception exception = assertThrows(FechaInvalidaException.class, () -> {
            Educacion educacion = new Educacion(912L, "UTN FRVM", "Testing 2023", 2028, 2023, null);
        });
        String actual = exception.getMessage();
        String esperado = "El año de ingreso no puede ser mayor que el año de egreso";
        assertEquals(esperado, actual);
    } 

}