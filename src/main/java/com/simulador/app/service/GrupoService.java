package com.simulador.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simulador.app.model.dao.GrupoRepository;
import com.simulador.app.model.entity.Grupo;

@Service
public class GrupoService implements IGrupoService{

	@Autowired
	public GrupoRepository grupoRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Grupo> findAll() {
		// TODO Auto-generated method stub
		return (List<Grupo>) grupoRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Grupo grupo) {
		// TODO Auto-generated method stub
		grupoRepository.save(grupo);
	}

	@Override
	@Transactional(readOnly=true)
	public Grupo findById(Long id) {
		// TODO Auto-generated method stub
		return grupoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		grupoRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Grupo> encontrarGrupos(Long id) {
		// TODO Auto-generated method stub
		return grupoRepository.encontrarGrupos(id);
	}

}
