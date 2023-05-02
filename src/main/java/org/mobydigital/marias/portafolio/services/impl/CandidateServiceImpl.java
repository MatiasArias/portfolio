package org.mobydigital.marias.portafolio.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.mobydigital.marias.portafolio.models.entities.Candidate;
import org.mobydigital.marias.portafolio.models.views.CandidateDto;
import org.mobydigital.marias.portafolio.models.views.SkillDto;
import org.mobydigital.marias.portafolio.repositories.CandidateRepository;
import org.mobydigital.marias.portafolio.services.CandidateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository repository;

    private final ModelMapper modelMapper = new ModelMapper();

    private static final String ID_NOT_FOUND = "Skill was not found by id - id: ";
    @Override
    public CandidateDto createCandidate(CandidateDto candidateDto) {
        repository.save(modelMapper.map(candidateDto, Candidate.class));
        return candidateDto;
    }

    @Override
    public List<CandidateDto> findAll() {
        return repository.findAll().stream()
                .map(candidate -> modelMapper.map(candidate, CandidateDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCandidate(Long id) {
        Optional.ofNullable(getCandidateById(id)).ifPresentOrElse(
                candidate -> repository.deleteById(id),
                () -> {
                    log.error(ID_NOT_FOUND+id);
                    throw new EntityNotFoundException(ID_NOT_FOUND+id);
                }
        );
    }

    @Override
    public CandidateDto getCandidateById(Long id) {
        return repository.findById(id).map(
               candidate -> modelMapper.map(candidate,CandidateDto.class
                )).orElseThrow(()->{
            log.error(ID_NOT_FOUND+id);
            return new EntityNotFoundException(ID_NOT_FOUND + id);
        });
    }

    @Override
    public void updateCandidate(Long id, CandidateDto candidateDto) {
        repository.findById(id).ifPresentOrElse(
                candidate -> {
                    candidate.setName(candidateDto.getName());
                    candidate.setLastname(candidateDto.getLastname());
                    candidate.setEmail(candidateDto.getEmail());
                    repository.save(candidate);
                },()->{
                    log.error(ID_NOT_FOUND+id);
                    throw new EntityNotFoundException(ID_NOT_FOUND+id);
                }
        );
    }
}
