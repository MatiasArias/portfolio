package org.mobydigital.marias.portafolio.repositories;

import org.mobydigital.marias.portafolio.models.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
