package com.simulador.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simulador.app.model.dao.RoundRepository;
import com.simulador.app.model.entity.Round;

@Service
public class RoundService implements IRoundService{

	@Autowired
	public RoundRepository roundrepository;
	
	@Override
	@Transactional
	public List<Round> findAll() {
		// TODO Auto-generated method stub
		return (List<Round>) roundrepository.findAll();
	}

	@Override
	@Transactional
	public void save(Round round) {
		// TODO Auto-generated method stub
		roundrepository.save(round);
		
	}

	@Override
	@Transactional
	public Round findById(Long id) {
		// TODO Auto-generated method stub
		return roundrepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		roundrepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Round> encontrarRounds(Long id) {
		// TODO Auto-generated method stub
		return roundrepository.encontrarRounds(id);
	}

}
