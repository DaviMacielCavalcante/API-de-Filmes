package com.apiDeFilmes.enums;

public enum Cartao {

	CREDITO(1, "Crédito"), DEBITO(2, "Débito");
	
	private int cod;
	private String descricao;
	
	private Cartao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Cartao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Cartao x : Cartao.values()) {
			return x;
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
