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

import com.apiDeFilmes.enums.ClassificacaoIndicativa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "perfil_e_controle_parental")
public class perfil_e_controle_parental implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;	
	
	@Column(name = "restricao_etaria")
	private Integer RestricaoEtaria;
	
	@Column(name = "imagem_url")
	private String imagemURL;			
	
	@JsonManagedReference
	@ManyToMany	
	@JoinTable(name = "conta_perfil",joinColumns = @JoinColumn(name = "id_perfis", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_conta", referencedColumnName = "id"))
	private List<Conta> conta = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany	
	@JoinTable(name = "filmes_perfil",joinColumns = @JoinColumn(name = "id_perfis", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_filmes", referencedColumnName = "id"))
	private List<Filmes> filmes = new ArrayList<>(); 
	
	public perfil_e_controle_parental() {
		
	}

	public perfil_e_controle_parental(String nome, ClassificacaoIndicativa restricaoEtaria,
			String imagemURL) {
		this.nome = nome;		
		RestricaoEtaria = restricaoEtaria.getCod();
		this.imagemURL = imagemURL;
	}	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

	public ClassificacaoIndicativa getRestricaoEtaria() {
		return ClassificacaoIndicativa.toEnum(RestricaoEtaria);
	}

	public void setRestricaoEtaria(ClassificacaoIndicativa restricaoEtaria) {
		RestricaoEtaria = restricaoEtaria.getCod();
	}

	public String getImagemURL() {
		return imagemURL;
	}

	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
	}

	public List<Conta> getConta() {
		return conta;
	}

	public List<Filmes> getFilmes() {
		return filmes;
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
		perfil_e_controle_parental other = (perfil_e_controle_parental) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}	
}
