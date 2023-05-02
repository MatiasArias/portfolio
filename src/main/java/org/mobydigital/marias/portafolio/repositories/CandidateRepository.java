package org.mobydigital.marias.portafolio.repositories;

import org.mobydigital.marias.portafolio.models.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
