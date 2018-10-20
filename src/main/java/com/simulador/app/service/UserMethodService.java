package com.simulador.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulador.app.model.dao.IUserMethodRepository;
import com.simulador.app.model.entity.Users;


@Service
public class UserMethodService implements IUserMethodService {

	@Autowired
	private IUserMethodRepository userMethodRepository;

	@Override
	public void save(Users users) {
		// TODO Auto-generated method stub
		userMethodRepository.save(users);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userMethodRepository.deleteById(id);
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return (List<Users>)userMethodRepository.findAll();
	}

	@Override
	public Users obtenerUsuarioPorUsername(String username) {
		// TODO Auto-generated method stub
		return userMethodRepository.findUserByUsername(username);
	}

}
