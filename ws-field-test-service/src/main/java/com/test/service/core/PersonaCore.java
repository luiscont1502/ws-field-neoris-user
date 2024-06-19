package com.test.service.core;

import com.neoris.persistence.postgres.entity.ClienteEntity;
import com.neoris.persistence.postgres.entity.PersonaEntity;
import com.neoris.persistence.postgres.service.ClienteService;
import com.neoris.persistence.postgres.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Objects;

@Component
public class PersonaCore {
    @Autowired
    private PersonaService personaService;
    @Autowired
    private ClienteService clienteService;

    public ClienteEntity saveOrUpdate(ClienteEntity request){
        ClienteEntity cliente = new ClienteEntity();
        if(request.getIdPersona()!=0){
            cliente=clienteService.findClienteById(request.getIdPersona());
            cliente.setClienteId(request.getIdentificacion());
            cliente.setEdad(request.getEdad());
            cliente.setNombre(request.getNombre());
            cliente.setGenero(request.getGenero());
            cliente.setContrasena(request.getContrasena());
            cliente.setIdentificacion(request.getIdentificacion());
            cliente.setDireccion(request.getDireccion());
            cliente.setTelefono(request.getTelefono());
            cliente.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
            return clienteService.saveOrUpdate(cliente);
        }else{
            request.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
            request.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        }
        return clienteService.saveOrUpdate(request);

    }

}
