package com.neoris.persistence.postgres.service;

import com.neoris.persistence.postgres.entity.PersonaEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService {
    PersonaEntity saveOrUpdate(PersonaEntity entity);
    List<PersonaEntity> findAllPersona(Pageable pageable);
    PersonaEntity findPersonaFinById(Integer id);

}
