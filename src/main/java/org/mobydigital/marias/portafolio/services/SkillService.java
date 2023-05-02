package org.mobydigital.marias.portafolio.services;

import org.mobydigital.marias.portafolio.models.views.SkillDto;

import java.util.List;

public interface SkillService {
    SkillDto createSkill(SkillDto skillDto);

    List<SkillDto> findAll();

    void deleteSkill(Long id);

    SkillDto getSkillById(Long id);

    void updateSkill(Long id, SkillDto skillDto);
}
