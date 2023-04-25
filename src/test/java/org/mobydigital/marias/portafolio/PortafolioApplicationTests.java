package org.mobydigital.marias.portafolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mobydigital.marias.portafolio.models.entities.Educacion;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PortafolioApplicationTests {

	@Test
	void testNombreEducacion() {
		Educacion educacion = new Educacion();
		educacion.setTitulo("Testing");
		String real = educacion.getTitulo();
		String esperado = "Testing";
		assertEquals(esperado,real);
	}

}
