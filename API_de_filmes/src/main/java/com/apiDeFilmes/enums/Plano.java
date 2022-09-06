package com.apiDeFilmes.enums;

public enum Plano {

	BASICO(1, "Plano"), PADRAO(2, "Padrão"), PREMIUM(3, "PREMIUM");
	
	private int cod;
	private String descricao;
	
	private Plano(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Plano toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Plano x : Plano.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}			
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
