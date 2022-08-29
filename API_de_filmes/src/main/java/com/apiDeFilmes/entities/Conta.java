package com.apiDeFilmes.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;

import com.apiDeFilmes.enums.Plano;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tipo_plano")
	private Integer tipoPlano;
	private String email;
	private String senha;
	private String telefone;	
	
	@ManyToMany
	@JoinTable(name = "conta_pagamento",joinColumns = @JoinColumn(name = "id_conta", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_pagamento", referencedColumnName = "id"))
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();		
	
	@JsonBackReference
	@ManyToMany	
	@JoinTable(name = "conta_perfil",joinColumns = @JoinColumn(name = "id_perfis", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_conta", referencedColumnName = "id"))
	private List<perfil_e_controle_parental> perfil = new ArrayList<>();
	
	public Conta() {		
	}	

	public Conta(Plano tipoPlano, String email, String senha, String telefone, List<Pagamento> pagamentos) {
		this.tipoPlano = tipoPlano.getCod();
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.pagamentos = pagamentos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Plano getTipoPlano() {
		return Plano.toEnum(tipoPlano);
	}

	public void setTipoPlano(Plano tipoPlano) {
		this.tipoPlano = tipoPlano.getCod();
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

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public List<perfil_e_controle_parental> getPerfis() {
		return perfil;
	}

	public void setPerfis(List<perfil_e_controle_parental> perfis) {
		this.perfil = perfis;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}	
}
