package com.prueba.jiut.apicreausuario.controller;

import com.prueba.jiut.apicreausuario.dto.ResponseDTO;
import com.prueba.jiut.apicreausuario.dto.UsuarioDTO;
import com.prueba.jiut.apicreausuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/crea-usuario")
    public ResponseEntity<ResponseDTO> crearUsuario(@RequestBody UsuarioDTO nuevoUsuario){
        return new ResponseEntity<>(usuarioService.crearUsuario(nuevoUsuario), HttpStatus.OK);
    }
}
