package com.simulador.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulador.app.model.entity.Linea;

@Repository
public interface LineaRepository extends JpaRepository<Linea, Long>{

}
