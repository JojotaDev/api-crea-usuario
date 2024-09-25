package com.prueba.jiut.apicreausuario.utils;

import com.prueba.jiut.apicreausuario.dto.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorExcepciones {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseErrorDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(new ResponseErrorDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
