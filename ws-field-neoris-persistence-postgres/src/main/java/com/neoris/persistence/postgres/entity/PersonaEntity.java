package com.neoris.persistence.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "persona", schema = "public", catalog = "neoris")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_persona")
    private int idPersona;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "genero")
    private String genero;
    @Basic
    @Column(name = "edad")
    private Integer edad;
    @Basic
    @Column(name = "identificacion")
    private String identificacion;
    @Basic
    @Column(name = "estado")
    private String estado;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;
    @Basic
    @Column(name = "fecha_modificacion")
    private Timestamp fechaModificacion;
    /*@OneToOne(mappedBy = "personaByIdPersona")
    private ClienteEntity clienteByIdPersona;*/

}
