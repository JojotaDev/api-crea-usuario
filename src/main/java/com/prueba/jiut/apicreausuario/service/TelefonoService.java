package com.prueba.jiut.apicreausuario.service;

import com.prueba.jiut.apicreausuario.dto.TelefonoDTO;
import com.prueba.jiut.apicreausuario.model.TelefonoModel;

public interface TelefonoService {

    public TelefonoModel creaContactoTelefonicoUsuario(TelefonoDTO telefonoDTO, Long idUsuario);
}
