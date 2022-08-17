package com.apiDeFilmes.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Integer ano;
	private Double duracao;
	private String sinopse;
	private Integer faixaEtaria;
	private String trailerURL;
	private String imgPosterURL;
	
	private Set<Diretor> direcao = new HashSet<>();
	private Set<Ator> elenco = new HashSet<>();
	private Set<Roteirista> roteiro = new HashSet<>();
	private Set<Genero> generos = new HashSet<>();
	
	@ManyToOne
	private Set<PerfilEControleParental> perfis = new HashSet<>();
	
	public Filme() {		
	}

	public Filme(String titulo, Integer ano, Double duracao, String sinopse, Integer faixaEtaria, String trailerURL,
			String imgPosterURL) {
		this.titulo = titulo;
		this.ano = ano;
		this.duracao = duracao;
		this.sinopse = sinopse;
		this.faixaEtaria = faixaEtaria;
		this.trailerURL = trailerURL;
		this.imgPosterURL = imgPosterURL;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Integer getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(Integer faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getTrailerURL() {
		return trailerURL;
	}

	public void setTrailerURL(String trailerURL) {
		this.trailerURL = trailerURL;
	}

	public String getImgPosterURL() {
		return imgPosterURL;
	}

	public void setImgPosterURL(String imgPosterURL) {
		this.imgPosterURL = imgPosterURL;
	}

	public Set<Diretor> getDirecao() {
		return direcao;
	}

	public Set<Ator> getElenco() {
		return elenco;
	}

	public Set<Roteirista> getRoteiro() {
		return roteiro;
	}

	public Set<Genero> getGeneros() {
		return generos;
	}

	public Set<PerfilEControleParental> getPerfis() {
		return perfis;
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
		Filme other = (Filme) obj;
		return Objects.equals(id, other.id);
	}	
}
