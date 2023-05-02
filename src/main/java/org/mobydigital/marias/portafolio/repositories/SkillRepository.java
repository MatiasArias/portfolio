package org.mobydigital.marias.portafolio.repositories;

import org.mobydigital.marias.portafolio.models.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
