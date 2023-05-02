package org.mobydigital.marias.portafolio.repositories;
;
import org.mobydigital.marias.portafolio.models.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
