package com.pgeteste.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Selective {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "selective_codigo")
	private Long selectiveCodigo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo", insertable=false, updatable=false)
	private Usuario realizador;
	
	@NotNull
	@Column(name="periodo_inicial")
	private LocalDate periodoInicial;
	
	@NotNull
	@Column(name="periodo_final")
	private LocalDate periodoFinal;
	
	

	public Long getSelectiveCodigo() {
		return selectiveCodigo;
	}

	public void setSelectiveCodigo(Long selectiveCodigo) {
		this.selectiveCodigo = selectiveCodigo;
	}

	public Usuario getRealizador() {
		return realizador;
	}

	public void setRealizador(Usuario realizador) {
		this.realizador = realizador;
	}

	public LocalDate getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(LocalDate periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public LocalDate getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(LocalDate periodoFinal) {
		this.periodoFinal = periodoFinal;
	}
}
