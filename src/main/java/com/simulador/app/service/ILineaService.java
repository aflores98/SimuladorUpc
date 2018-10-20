package com.simulador.app.service;

import java.util.List;

import com.simulador.app.model.entity.Linea;

public interface ILineaService {

	public List<Linea> findAll();

	public void save(Linea juego);

	public Linea findById(Long id);

	public void deleteById(Long id);
}
