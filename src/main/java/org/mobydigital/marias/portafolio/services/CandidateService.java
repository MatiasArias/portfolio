package org.mobydigital.marias.portafolio.services;

import org.mobydigital.marias.portafolio.models.views.CandidateDto;

import java.util.List;

public interface CandidateService {
    CandidateDto createCandidate(CandidateDto candidateDto);

    List<CandidateDto> findAll();

    void deleteCandidate(Long id);

    CandidateDto getCandidateById(Long id);

    void updateCandidate(Long id, CandidateDto candidateDto);
}
