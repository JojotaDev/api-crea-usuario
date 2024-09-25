package com.prueba.jiut.apicreausuario.repository;

import com.prueba.jiut.apicreausuario.model.TelefonoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoRepository extends JpaRepository<TelefonoModel, Long> {
}
