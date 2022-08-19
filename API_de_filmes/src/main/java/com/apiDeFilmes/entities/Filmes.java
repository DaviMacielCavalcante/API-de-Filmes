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
import javax.persistence.ManyToOne;

import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "filmes")
public class Filmes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Integer ano;
	private Double duracao;
	private String sinopse;
	
	@Column(name = "faixa_etaria")
	private Integer faixaEtaria;
	
	@Column(name = "trailer_url")
	private String trailerURL;
	
	@Column(name = "img_poster_url")
	private String imgPosterURL;
	
	@ManyToMany
	@JoinTable(name = "filmes_diretores", joinColumns = @JoinColumn(name = "id_filmes", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_diretores", referencedColumnName = "id"))
	private List<Diretor> diretor = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "filmes_atores", joinColumns = @JoinColumn(name = "id_filmes", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_atores", referencedColumnName = "id"))	
	private List<Ator> ator = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "filmes_roteiristas", joinColumns = @JoinColumn(name = "id_filmes", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_roteiristas", referencedColumnName = "id"))	
	private List<Roteirista> roteirista = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "filmes_generos", joinColumns = @JoinColumn(name = "id_filmes", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_generos", referencedColumnName = "id"))	
	private List<Genero> genero = new ArrayList<>();
	
	@ManyToOne	
	private PerfilEControleParental id_perfis;
	
	public Filmes() {		
	}

	public Filmes(String titulo, Integer ano, Double duracao, String sinopse, Integer faixaEtaria, String trailerURL,
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

	public List<Diretor> getDirecao() {
		return diretor;
	}

	public List<Ator> getElenco() {
		return ator;
	}

	public List<Roteirista> getRoteiro() {
		return roteirista;
	}

	public List<Genero> getGeneros() {
		return genero;
	}

	public PerfilEControleParental getPerfis() {
		return id_perfis;
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
		Filmes other = (Filmes) obj;
		return Objects.equals(id, other.id);
	}	
}
