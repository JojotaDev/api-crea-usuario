package com.prueba.jiut.apicreausuario.service;

import com.prueba.jiut.apicreausuario.dto.ResponseDTO;
import com.prueba.jiut.apicreausuario.dto.UsuarioDTO;

public interface UsuarioService {

    public ResponseDTO crearUsuario(UsuarioDTO usuarioDTO);
}
