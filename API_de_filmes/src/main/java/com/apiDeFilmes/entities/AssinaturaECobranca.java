package com.apiDeFilmes.entities;

import java.io.Serializable;
import java.util.Objects;

public class AssinaturaECobranca implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	private String telefone;
	
	public AssinaturaECobranca() {		
	}

	public AssinaturaECobranca(String email, String senha, String telefone) {
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssinaturaECobranca other = (AssinaturaECobranca) obj;
		return Objects.equals(email, other.email);
	}	
}
