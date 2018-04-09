package com.pgeteste.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="selective_usuario")
public class SelectiveUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name="selective_codigo")
	private Selective selective;
	
	@ManyToOne
	@JoinColumn(name="usuario_codigo")
	private Usuario usuario;
	
	public SelectiveUsuario() {}
	
	public SelectiveUsuario(Usuario usuario, Selective selective) {
		this.usuario = usuario;
		this.selective = selective;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Selective getSelective() {
		return selective;
	}

	public void setSelective(Selective selective) {
		this.selective = selective;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
