package com.simulador.app.service;

import java.util.List;

import com.simulador.app.model.entity.Round;

public interface IRoundService {

	public List<Round> findAll();

	public void save(Round round);

	public Round findById(Long id);

	public void deleteById(Long id);
	
	public List<Round> encontrarRounds(Long id);
}
