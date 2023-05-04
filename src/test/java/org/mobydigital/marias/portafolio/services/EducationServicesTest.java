package org.mobydigital.marias.portafolio.services;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mobydigital.marias.portafolio.models.entities.Education;
import org.mobydigital.marias.portafolio.models.views.EducationDto;
import org.mobydigital.marias.portafolio.repositories.EducationRepository;
import org.mobydigital.marias.portafolio.services.impl.EducationServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EducationServicesTest {

    @Mock
    private EducationRepository educationRepository;

    @InjectMocks
    private EducationServiceImpl educationService;

    @Test
    void testEducacionById() {
        Education education = new Education();
        education.setInstitution("UTN FRVM");
        education.setDegree("Testing 2023");
        when(educationRepository.findById(1L)).thenReturn(Optional.of(education));

        EducationDto result = educationService.getEducationById(1L);

        assertEquals(result.getInstitution(), education.getInstitution());
        assertEquals(result.getDegree(), education.getDegree());
        verify(educationRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateEducacion() {
        Education education = new Education();
        education.setInstitution("UTN FRVM");
        education.setDegree("Testing");

        when(educationRepository.save(education)).thenReturn(education);

        EducationDto educacionDTO = new EducationDto();
        educacionDTO.setInstitution("UTN FRVM");
        educacionDTO.setDegree("Testing");

        EducationDto result = educationService.createEducation(educacionDTO);

        assertEquals(result.getInstitution(), education.getInstitution());
        assertEquals(result.getDegree(), education.getDegree());
        verify(educationRepository, times(1)).save(education);
    }
}

