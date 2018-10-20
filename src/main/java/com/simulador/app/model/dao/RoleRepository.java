package com.simulador.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simulador.app.model.entity.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query("select r from Role r where r.user.id=?1")
	public List<Role> findRoleByUsuario(Long id);
}
