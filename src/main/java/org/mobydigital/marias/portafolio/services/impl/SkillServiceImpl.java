package org.mobydigital.marias.portafolio.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.mobydigital.marias.portafolio.models.entities.Skill;
import org.mobydigital.marias.portafolio.models.views.SkillDto;
import org.mobydigital.marias.portafolio.repositories.SkillRepository;
import org.mobydigital.marias.portafolio.services.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository repository;
    private final ModelMapper modelMapper = new ModelMapper();

    private static final String ID_NOT_FOUND = "Skill was not found by id - id: ";

    @Override
    public SkillDto createSkill(SkillDto skillDto) {
        repository.save(modelMapper.map(skillDto, Skill.class));
        return skillDto;
    }

    @Override
    public List<SkillDto> findAll() {
        return repository.findAll().stream()
                .map(skill -> modelMapper.map(skill, SkillDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSkill(Long id) {
        Optional.ofNullable(getSkillById(id)).ifPresentOrElse(
                skill -> repository.deleteById(id),
                () -> {
                    log.error(ID_NOT_FOUND+id);
                    throw new EntityNotFoundException(ID_NOT_FOUND+id);
                }
        );
    }

    @Override
    public SkillDto getSkillById(Long id) {
        return repository.findById(id).map(
                skill -> modelMapper.map(skill,SkillDto.class
        )).orElseThrow(()->{
            log.error(ID_NOT_FOUND+id);
            return new EntityNotFoundException(ID_NOT_FOUND + id);
        });
    }

    @Override
    public void updateSkill(Long id, SkillDto skillDto) {
    repository.findById(id).ifPresentOrElse(
            skill -> {
                skill.setName(skillDto.getName());
                skill.setDescription(skillDto.getDescription());
                repository.save(skill);
            },()->{
                log.error(ID_NOT_FOUND+id);
                throw new EntityNotFoundException(ID_NOT_FOUND+id);
            }
    );
    }
}
