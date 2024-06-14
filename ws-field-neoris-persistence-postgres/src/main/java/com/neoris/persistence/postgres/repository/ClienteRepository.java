package com.neoris.persistence.postgres.repository;

import com.neoris.persistence.postgres.entity.ClienteEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {

    @Query("select cl from ClienteEntity cl where cl.estado='1'")
    List<ClienteEntity> findAllCliente(Pageable pageable);
    @Query("select cl from ClienteEntity cl where cl.idPersona=:idPersona")
    ClienteEntity findClienteById(@Param("idPersona") Integer idPersona);
}
