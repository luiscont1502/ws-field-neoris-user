package com.neoris.persistence.postgres.service;

import com.neoris.persistence.postgres.entity.ClienteEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteService {
    List<ClienteEntity> findAllCliente(Pageable pageable);
    ClienteEntity findClienteById(Integer idPersona);

    ClienteEntity saveOrUpdate(ClienteEntity clienteEntity);
}
