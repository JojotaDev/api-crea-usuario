package com.prueba.jiut.apicreausuario.service.impl;

import com.prueba.jiut.apicreausuario.dto.TelefonoDTO;
import com.prueba.jiut.apicreausuario.model.TelefonoModel;
import com.prueba.jiut.apicreausuario.repository.TelefonoRepository;
import com.prueba.jiut.apicreausuario.service.TelefonoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TelefonoServiceImpl implements TelefonoService {

    private final TelefonoRepository telefonoRepository;

    @Override
    public TelefonoModel creaContactoTelefonicoUsuario(TelefonoDTO telefonoDTO, Long idUsuario) {
        if (telefonoDTO.getNumber() == null || telefonoDTO.getNumber().isEmpty()) {
            throw new IllegalArgumentException("El número de teléfono es obligatorio");
        }
        if (telefonoDTO.getCitycode() == null || telefonoDTO.getCitycode().isEmpty()) {
            throw new IllegalArgumentException("El código de ciudad es obligatorio");
        }
        if (telefonoDTO.getContrycode() == null || telefonoDTO.getContrycode().isEmpty()) {
            throw new IllegalArgumentException("El código de país es obligatorio");
        }
        return telefonoRepository.save(newTelefonoDtoToModel(telefonoDTO, idUsuario));
    }

    private TelefonoModel newTelefonoDtoToModel(TelefonoDTO dto, Long idUsuario){
        TelefonoModel model = new TelefonoModel();
        model.setNumber(dto.getNumber());
        model.setCitycode(dto.getCitycode());
        model.setContrycode(dto.getContrycode());
        model.setIdUsuario(idUsuario);
        return model;
    }
}
