package com.simulador.app.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Linea implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_linea;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_grupo")
	private Grupo grupo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_round")
	private Round round;

	@NotNull
	private int compra;
	
	@NotNull
	private int venta;
	
	public int getCompra() {
		return compra;
	}

	public void setCompra(int compra) {
		this.compra = compra;
	}

	public int getVenta() {
		return venta;
	}

	public void setVenta(int venta) {
		this.venta = venta;
	}

	public Long getId_linea() {
		return id_linea;
	}

	public void setId_linea(Long id_linea) {
		this.id_linea = id_linea;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}	
	

}
