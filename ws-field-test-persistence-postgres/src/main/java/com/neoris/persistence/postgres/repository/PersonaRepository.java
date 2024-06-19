package com.neoris.persistence.postgres.repository;

import com.neoris.persistence.postgres.entity.PersonaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity,Integer> {
    @Query("select p from ClienteEntity  p where p.estado='1'")
    List<PersonaEntity> findAllByIdPersona(Pageable pageable);
}
