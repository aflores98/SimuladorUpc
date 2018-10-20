package com.simulador.app.service;

import java.util.List;

import com.simulador.app.model.entity.Users;


public interface IUserMethodService {

public void save(Users users);
	
	public void deleteById(Long id);
	
	public List<Users> findAll();
	
	public Users obtenerUsuarioPorUsername(String username);
	
}
