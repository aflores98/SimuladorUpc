package com.simulador.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulador.app.model.entity.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);
}
