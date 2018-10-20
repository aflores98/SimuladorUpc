package com.simulador.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simulador.app.model.entity.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long>{
	
	@Query(value="select * from round order by id_round  desc limit ?1", nativeQuery=true)
	public List<Round> encontrarRounds(Long id);
}
