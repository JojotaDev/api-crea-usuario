package com.prueba.jiut.apicreausuario.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<TelefonoDTO> phones;

}
