package com.prueba.jiut.apicreausuario.service.impl;

import com.prueba.jiut.apicreausuario.dto.ResponseDTO;
import com.prueba.jiut.apicreausuario.dto.UsuarioDTO;
import com.prueba.jiut.apicreausuario.model.UsuarioModel;
import com.prueba.jiut.apicreausuario.repository.UsuarioRepository;
import com.prueba.jiut.apicreausuario.service.TelefonoService;
import com.prueba.jiut.apicreausuario.service.UsuarioService;
import com.prueba.jiut.apicreausuario.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TelefonoService telefonoService;

    @Override
    public ResponseDTO crearUsuario(UsuarioDTO usuarioDTO) {
        UsuarioModel savedUser = usuarioRepository.save(newUsuarioDtoToModel(usuarioDTO));
        usuarioDTO.getPhones().forEach(phoneDTO ->
                telefonoService.creaContactoTelefonicoUsuario(phoneDTO, savedUser.getId())
        );
        return new ResponseDTO("Operación exitosa.", savedUser);
    }

    private UsuarioModel newUsuarioDtoToModel(UsuarioDTO usuarioDTO){
        if (usuarioDTO.getName() == null || usuarioDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }

        if (usuarioDTO.getPhones() == null || usuarioDTO.getPhones().isEmpty()) {
            throw new IllegalArgumentException("Debe ingresar al menos un número de teléfono.");
        }

        if (!StringUtils.esFormatoPasswordValido(usuarioDTO.getPassword())) {
            throw new IllegalArgumentException("La contraseña debe contener al menos una letra mayúscula, una letra minúscula y al menos 2 dígitos.");
        }

        if (!StringUtils.esFormatoEmailValido(usuarioDTO.getEmail())){
            throw new IllegalArgumentException("El formato del correo no es válido.");
        }

        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El correo ya ha sido registrado.");
        }

        UsuarioModel model = new UsuarioModel();
        model.setName(usuarioDTO.getName());
        model.setEmail(usuarioDTO.getEmail());
        model.setPassword(usuarioDTO.getPassword());
        model.setCreated(new Date());
        model.setModified(new Date());
        model.setLast_login(new Date());
        model.setToken("");
        model.setIsactive(Boolean.TRUE);
        return model;
    }
}
