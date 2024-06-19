package com.neoris.persistence.postgres.service.impl;

import com.neoris.persistence.postgres.entity.ClienteEntity;
import com.neoris.persistence.postgres.repository.ClienteRepository;
import com.neoris.persistence.postgres.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<ClienteEntity> findAllCliente(Pageable pageable) {
        return clienteRepository.findAllCliente(pageable);
    }

    @Override
    public ClienteEntity findClienteById(Integer idPersona) {
        return clienteRepository.findClienteById(idPersona);
    }

    @Override
    public ClienteEntity saveOrUpdate(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }
}
