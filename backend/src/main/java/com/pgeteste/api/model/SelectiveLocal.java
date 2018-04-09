package com.pgeteste.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="selective_local")
public class SelectiveLocal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name="selective_codigo")
	private Selective selective;
	
	@ManyToOne
	@JoinColumn(name="local_codigo")
	private Local local;
	
	public SelectiveLocal() {}
	
	public SelectiveLocal(Local local, Selective selective) {
		this.local = local;
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
}
