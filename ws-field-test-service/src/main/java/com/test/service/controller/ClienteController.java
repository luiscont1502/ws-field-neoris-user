package com.test.service.controller;

import com.neoris.persistence.postgres.entity.ClienteEntity;
import com.neoris.persistence.postgres.entity.PersonaEntity;
import com.neoris.persistence.postgres.service.ClienteService;
import com.neoris.persistence.postgres.service.PersonaService;
import com.test.service.core.PersonaCore;
import com.test.service.enums.EnumResponse;
import com.test.service.model.ResponseData;
import com.test.service.model.SearchDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Log4j2
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private PersonaService personaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private PersonaCore personaCore;
    @PostMapping("/allClientes")
    public ResponseEntity<ResponseData<List<ClienteEntity>>> findAllClientes(@RequestBody SearchDto searchDto){
        ResponseData<List<ClienteEntity>> response=new ResponseData<>(EnumResponse.VACIO.code());
        try{
            List<ClienteEntity> address= clienteService.findAllCliente(PageRequest.of(searchDto.getPage(),searchDto.getSize()));
            response.setData(address);
        }catch(Exception e){
            log.info("Error findAllPersona(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/savecliente")
    public ResponseEntity<ResponseData<ClienteEntity>> savecliente(@RequestBody ClienteEntity entity){
        ResponseData<ClienteEntity> response=new ResponseData<>(EnumResponse.VACIO.code());
        try{
            ClienteEntity clienteEntity= personaCore.saveOrUpdate(entity);
            response.setData(clienteEntity);
        }catch(Exception e){
            log.info("Error SavePersona(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseData<ClienteEntity>> updatePersona(@RequestBody ClienteEntity entity){
        ResponseData<ClienteEntity> response=new ResponseData<>(EnumResponse.VACIO.code());
        try{
            ClienteEntity persona= personaCore.saveOrUpdate(entity);
            response.setData(persona);
        }catch(Exception e){
            log.info("Error SavePersona(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseData<PersonaEntity>> findPersonaById(@PathVariable("id") Integer id){
        ResponseData<PersonaEntity> response=new ResponseData<>(EnumResponse.VACIO.code());
        try{
            PersonaEntity persona= personaService.findPersonaFinById(id);
            response.setData(persona);
        }catch(Exception e){
            log.info("Error findPersonaById(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<ClienteEntity>> deleteClientefindById(@PathVariable("id") Integer id){
        ResponseData<ClienteEntity> response=new ResponseData<>(EnumResponse.VACIO.code());
        try{
            ClienteEntity cliente= clienteService.findClienteById(id);
            cliente.setEstado("0");
            ClienteEntity deletePersona=clienteService.saveOrUpdate(cliente);
            response.setData(deletePersona);
        }catch(Exception e){
            log.info("Error deleteClientefindById(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
