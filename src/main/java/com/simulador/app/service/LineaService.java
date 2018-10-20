package com.simulador.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simulador.app.model.dao.LineaRepository;
import com.simulador.app.model.entity.Linea;

@Service
public class LineaService implements ILineaService{

	@Autowired
	public LineaRepository juegoRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Linea> findAll() {
		// TODO Auto-generated method stub
		return (List<Linea>)juegoRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Linea juego) {
		// TODO Auto-generated method stub
		juegoRepository.save(juego);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Linea findById(Long id) {
		// TODO Auto-generated method stub
		return juegoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		juegoRepository.deleteById(id);
	}

}
