package com.neoris.persistence.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "cliente", schema = "public", catalog = "neoris")
@PrimaryKeyJoinColumn(name = "id_persona")
public class ClienteEntity extends PersonaEntity{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_persona")
    private int idPersona;

    @Basic
    @Column(name = "cliente_id",unique = true)
    private String clienteId;
    @Basic
    @Column(name = "contrasena")
    private String contrasena;

}
