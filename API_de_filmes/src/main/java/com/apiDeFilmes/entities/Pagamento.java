package com.apiDeFilmes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

import com.apiDeFilmes.enums.Cartao;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Component("pagamento")
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero_cartao")
	private String numeroCartao;
	
	@Column(name = "data_cobranca")
	private Date datacobranca;	
	
	@Column(name = "tipo_cartao")
	private Integer tipoCartao;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "conta_pagamento",joinColumns = @JoinColumn(name = "id_conta", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_pagamento", referencedColumnName = "id"))
	private List<Conta> conta = new ArrayList<Conta>();
	
	public Pagamento() {		
	}

	public Pagamento(String numeroCartao, Date datacobranca, Cartao tipoCartao) {
		this.numeroCartao = numeroCartao;
		this.datacobranca = datacobranca;
		this.tipoCartao = tipoCartao.getCod();		
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDatacobranca(Date datacobranca) {
		this.datacobranca = datacobranca;
	}

	public void setConta(List<Conta> conta) {
		this.conta = conta;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Cartao getTipoCartao() {
		return Cartao.toEnum(tipoCartao);
	}

	public void setTipoCartao(Cartao tipoCartao) {
		this.tipoCartao = tipoCartao.getCod();
	}

	public Integer getId() {
		return id;
	}

	public Date getDatacobranca() {
		return datacobranca;
	}

	public List<Conta> getConta() {
		return conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta, id, tipoCartao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(id, other.id) && tipoCartao == other.tipoCartao;
	}	
}
