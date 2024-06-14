package com.neoris.persistence.postgres.service.impl;

import com.neoris.persistence.postgres.entity.PersonaEntity;
import com.neoris.persistence.postgres.repository.PersonaRepository;
import com.neoris.persistence.postgres.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public PersonaEntity saveOrUpdate(PersonaEntity entity) {
        return personaRepository.save(entity);
    }

    @Override
    public List<PersonaEntity> findAllPersona(Pageable pageable) {
        return personaRepository.findAllByIdPersona(pageable);
    }

    @Override
    public PersonaEntity findPersonaFinById(Integer id) {
        return personaRepository.getReferenceById(id);
    }
}
