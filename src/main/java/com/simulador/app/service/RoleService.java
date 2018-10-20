package com.simulador.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulador.app.model.dao.RoleRepository;
import com.simulador.app.model.entity.Role;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return ( List<Role>)roleRepository.findAll();
	}

	@Override
	public List<Role> findRoleByUsuario(Long id) {
		// TODO Auto-generated method stub
		return (List<Role>)roleRepository.findRoleByUsuario(id);
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

}
