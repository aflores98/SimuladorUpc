package com.simulador.app.service;

import java.util.List;

import com.simulador.app.model.entity.Role;


public interface IRoleService {

public List<Role> findAll();
	
	public List<Role> findRoleByUsuario(Long id);
	
	public void save(Role role);
	
}
