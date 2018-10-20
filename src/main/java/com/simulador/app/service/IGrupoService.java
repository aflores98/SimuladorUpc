package com.simulador.app.service;

import java.util.List;

import com.simulador.app.model.entity.Grupo;

public interface IGrupoService {
	

	public List<Grupo> findAll();
	
	public void save(Grupo grupo);
	
	public Grupo findById(Long id);
	
	public void deleteById(Long id);
	
	public List<Grupo> encontrarGrupos(Long id);

}
