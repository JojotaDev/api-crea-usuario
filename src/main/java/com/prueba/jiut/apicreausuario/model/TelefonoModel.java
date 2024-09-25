package com.prueba.jiut.apicreausuario.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TelefonoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String citycode;
    private String contrycode;
    @Column(name = "usuario_id")
    private Long idUsuario;
}
