package org.mobydigital.marias.portafolio.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mobydigital.marias.portafolio.models.views.EducationDto;
import org.mobydigital.marias.portafolio.services.impl.EducationServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
public class EducationControllerTest {


    private MockMvc mockMvc;
    @Mock
    private EducationServiceImpl educationService;

    @InjectMocks
    private EducationController educationController;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(educationController).build();
    }

    @Test
    @DisplayName("GET http://localhost:8080/educations - Success")
    void testEducaciones() throws Exception {
        EducationDto educacionDto = new EducationDto();
        educacionDto.setDegree("Testing");
        educacionDto.setInstitution("UTN FRVM");
        List<EducationDto> educaciones = new ArrayList<>();
        educaciones.add(educacionDto);

        when(educationService.findAll()).thenReturn(educaciones);

        mockMvc.perform(get("/educations"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET http://localhost:8080/educations/1 - Success")
    void testEducacionById() throws Exception {
        EducationDto educacionDto = new EducationDto();
        educacionDto.setDegree("Testing");
        educacionDto.setInstitution("UTN FRVM");

        when(educationService.getEducationById(1L)).thenReturn(educacionDto);

        mockMvc.perform(get("/educations/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.degree",is("Testing")))
                .andExpect(jsonPath("$.institution",is("UTN FRVM")));
    }

    @Test
    @DisplayName("POST http://localhost:8080/educations/create - Success")
    void testCreateEducacion() throws Exception {
        EducationDto educationDto = new EducationDto();
        educationDto.setDegree("Testing");
        educationDto.setInstitution("UTN FRVM");

        when(educationService.createEducation(Mockito.eq(educationDto))).thenReturn(educationDto);


        mockMvc.perform(post("/educations/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(educationDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.degree", is(equalTo(educationDto.getDegree()))))
                .andExpect(jsonPath("$.institution", is(equalTo(educationDto.getInstitution()))));
    }

    @Test
    @DisplayName("UPDATE http://localhost:8080/educations/update/1 - Success")
    void testUpdateEducation() throws Exception {
        EducationDto educationDtoPut = new EducationDto("UTN FRVM","Testing",2020,2021);

        mockMvc.perform(put("/educations/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(educationDtoPut)))
                        .andExpect(status().isOk());
        Mockito.verify(educationService,Mockito.times(1)).updateEducation(eq(1L),eq(educationDtoPut));
    }

    @Test
    @DisplayName("DELETE http://localhost:8080/educations/delete/1 - Success")
    void testDeleteEducacion() throws Exception {
        mockMvc.perform(delete("/educations/delete/1"))
                .andExpect(status().isNoContent());
        Mockito.verify(educationService,Mockito.times(1)).deleteEducation(eq(1L));
    }

}
