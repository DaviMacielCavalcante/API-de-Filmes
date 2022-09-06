package com.apiDeFilmes.enums;

public enum ClassificacaoIndicativa {

	LIVRE(1, "Livre"), ATE_10(2, "Não recomendado para menores de 10 anos"), 
	ATE_12(3, "Não recomendado para menores de 12 anos"), ATE_14(4, "Não recomendado para menores de 14 anos"),
	ATE_16(5, "Não recomendado para menores de 16 anos"), ATE_18(6, "Não recomendado para menores de 18 anos");
	
	private int cod;
	private String descricao;
	
	private ClassificacaoIndicativa(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static ClassificacaoIndicativa toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (ClassificacaoIndicativa x : ClassificacaoIndicativa.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}	
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
