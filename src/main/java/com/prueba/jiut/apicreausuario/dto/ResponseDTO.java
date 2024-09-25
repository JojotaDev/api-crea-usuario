package com.prueba.jiut.apicreausuario.dto;

import com.prueba.jiut.apicreausuario.model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private String mensaje;
    private UsuarioModel usuarioCreado;
}
