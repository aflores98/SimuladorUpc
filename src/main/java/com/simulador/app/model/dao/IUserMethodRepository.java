package com.simulador.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simulador.app.model.entity.Users;


@Repository
public interface IUserMethodRepository extends JpaRepository<Users, Long> {
	
	@Query("select u from Users u where u.username =?1")
	public Users findUserByUsername(String username);
}
