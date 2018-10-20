package com.simulador.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simulador.app.model.entity.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

	@Query(value="select * from grupo order by id_grupo  desc limit ?1", nativeQuery=true)
	public List<Grupo> encontrarGrupos(Long id);
	
}
