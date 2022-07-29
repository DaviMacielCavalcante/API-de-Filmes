package com.apiDeFilmes.entities;

import java.io.Serializable;
import java.util.Objects;

import com.apiDeFilmes.enums.ClassificacaoIndicativa;

public class PerfilEControleParental implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private ClassificacaoIndicativa RestricaoEtaria;
	private String imagemURL;
	
	private Conta conta;

	public PerfilEControleParental(String nome, String email, ClassificacaoIndicativa restricaoEtaria,
			String imagemURL) {
		this.nome = nome;
		this.email = email;
		RestricaoEtaria = restricaoEtaria;
		this.imagemURL = imagemURL;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ClassificacaoIndicativa getRestricaoEtaria() {
		return RestricaoEtaria;
	}

	public void setRestricaoEtaria(ClassificacaoIndicativa restricaoEtaria) {
		RestricaoEtaria = restricaoEtaria;
	}

	public String getImagemURL() {
		return imagemURL;
	}

	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
	}

	public Conta getConta() {
		return conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfilEControleParental other = (PerfilEControleParental) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}	
}
