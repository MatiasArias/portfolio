package org.mobydigital.marias.portafolio.models.entities;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mobydigital.marias.portafolio.exceptions.FechaInvalidaException;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

class EducationTest {


    @Test
    void testNombreEducacion() {
        Education education = new Education();
        education.setDegree("Testing 2023");
        String real = education.getDegree();
        String esperado = "Testing 2023";
        assertEquals(esperado, real);
    }

    @Test
    void testInstitucionEducacion() {
        Education education = new Education(912L, "UTN FRVM", "Testing 2023", 2023,2028,null);
        assertEquals("UTN FRVM", education.getInstitution());
    }

    @Test
    void testIdEducacion() {
        Education education = new Education(912L, "UTN FRVM", "Testing 2023", 2023, 2023,null);
        assertFalse(education.getIdEducation().compareTo(0L) < 0);
        assertTrue(education.getIdEducation().compareTo(0L) > 0);
    }

    @Test
    void testReferenciaEducacion() {
        Education education1 = new Education(912L, "UTN FRVM", "Testing 2023", 2023, 2023,null);
        Education education2 = new Education(912L, "UTN FRVM", "Testing 2023", 2023, 2023,null);
        assertEquals(education1, education2);
        education2.setDegree("Universidad Tecnologica Nacional - FRVM");
        assertNotEquals(education1, education2);
    }
}