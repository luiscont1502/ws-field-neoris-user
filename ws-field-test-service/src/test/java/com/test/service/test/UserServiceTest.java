package com.test.service.test;

import com.neoris.persistence.postgres.entity.ClienteEntity;
import com.neoris.persistence.postgres.repository.ClienteRepository;
import com.neoris.persistence.postgres.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private ClienteServiceImpl clienteService;
    @Mock
    private ClienteRepository clienteRepository;
    @Test
    public void testSaveCliente(){
        ClienteEntity cliente=new ClienteEntity();
        cliente.setNombre("Armando ch");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setIdentificacion("2568520");
        cliente.setDireccion("latacu");
        cliente.setTelefono("09598787452");
        cliente.setContrasena("dfjh");
        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(cliente);

        ClienteEntity cuentaResp = clienteService.saveOrUpdate(cliente);

        assertEquals("Armando ch", cuentaResp.getNombre());
        verify(clienteRepository, times(1)).save(cliente);

    }
}
