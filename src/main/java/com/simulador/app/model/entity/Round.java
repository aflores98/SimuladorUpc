package com.simulador.app.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Round implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_round;
	
	@NotNull
	private int materiaPrima;
	
	@NotNull
	private int producto;

	public Long getId_round() {
		return id_round;
	}

	public void setId_round(Long id_round) {
		this.id_round = id_round;
	}

	public int getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(int materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}
}
