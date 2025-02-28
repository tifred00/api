package com.narvasoft.apirest.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Clientes")
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Clientes  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "tarjeta")
    private String tarjeta;

    @Column(name = "clave")
    private String clave;

    @Column(name = "codigo")
    private String codigo;

}
