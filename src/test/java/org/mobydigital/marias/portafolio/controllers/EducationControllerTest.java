package org.mobydigital.marias.portafolio.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mobydigital.marias.portafolio.controllers.EducacionController;
import org.mobydigital.marias.portafolio.models.views.EducacionDto;
import org.mobydigital.marias.portafolio.services.impl.EducacionServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import org.springframework.mock.http.server.reactive.MockServerHttpRequest.BodyBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
public class EducacionControllerTest {


    private MockMvc mockMvc;
    @Mock
    private EducacionServiceImpl educacionService;

    @InjectMocks
    private EducacionController educacionController;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(educacionController).build();
    }

    @Test
    @DisplayName("GET http://localhost:8080/educaciones - Success")
    void testEducaciones() throws Exception {
        EducacionDto educacionDto = new EducacionDto();
        educacionDto.setTitulo("Testing");
        educacionDto.setInstitucion("UTN FRVM");
        List<EducacionDto> educaciones = new ArrayList<>();
        educaciones.add(educacionDto);

        when(educacionService.findAll()).thenReturn(educaciones);

        mockMvc.perform(get("/educaciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].titulo",is("Testing")))
                .andExpect(jsonPath("$.[0].institucion",is("UTN FRVM")));
    }

    @Test
    @DisplayName("GET http://localhost:8080/educaciones/1 - Success")
    void testEducacionById() throws Exception {
        EducacionDto educacionDto = new EducacionDto();
        educacionDto.setTitulo("Testing");
        educacionDto.setInstitucion("UTN FRVM");

        when(educacionService.getEducacionById(1L)).thenReturn(educacionDto);

        mockMvc.perform(get("/educaciones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo",is("Testing")))
                .andExpect(jsonPath("$.institucion",is("UTN FRVM")));
    }

    @Test
    @DisplayName("POST http://localhost:8080/educaciones/create - Success")
    void testCreateEducacion() throws Exception {
        EducacionDto educacionDto = new EducacionDto();
        educacionDto.setTitulo("Testing");
        educacionDto.setInstitucion("UTN FRVM");

        when(educacionService.createEducacion(Mockito.eq(educacionDto))).thenReturn(educacionDto);


        mockMvc.perform(post("/educaciones/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(educacionDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo", is(equalTo(educacionDto.getTitulo()))))
                .andExpect(jsonPath("$.institucion", is(equalTo(educacionDto.getInstitucion()))));
    }

    @Test
    @DisplayName("UPDATE http://localhost:8080/educaciones/update/1 - Success")
    void testUpdateEducacion() throws Exception {
        EducacionDto educacionDtoPut = new EducacionDto("UTN FRVM","Testing",2020,2021);

        mockMvc.perform(put("/educaciones/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(educacionDtoPut)))
                        .andExpect(status().isOk());
        Mockito.verify(educacionService,Mockito.times(1)).updateEducacion(eq(1L),eq(educacionDtoPut));
    }

    @Test
    @DisplayName("DELETE http://localhost:8080/educaciones/delete/1 - Success")
    void testDeleteEducacion() throws Exception {
        mockMvc.perform(delete("/educaciones/delete/1"))
                .andExpect(status().isNoContent());
        Mockito.verify(educacionService,Mockito.times(1)).deleteEducacion(eq(1L));
    }

}
