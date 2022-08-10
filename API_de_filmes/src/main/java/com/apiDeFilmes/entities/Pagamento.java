package com.apiDeFilmes.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.apiDeFilmes.enums.Cartao;

public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String numeroCartao;
	private Date datacobranca;
	private Integer tipoCartao;
	
	private Conta conta;
	
	public Pagamento() {		
	}

	public Pagamento(String numeroCartao, Date datacobranca, Cartao tipoCartao, Conta conta) {
		this.numeroCartao = numeroCartao;
		this.datacobranca = datacobranca;
		this.tipoCartao = tipoCartao.getCod();
		this.conta = conta;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDatacobranca(Date datacobranca) {
		this.datacobranca = datacobranca;
	}

	public void setConta(Conta conta) {
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

	public Conta getConta() {
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
