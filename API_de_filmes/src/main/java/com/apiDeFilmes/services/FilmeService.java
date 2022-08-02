package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Ator;
import com.apiDeFilmes.entities.Diretor;
import com.apiDeFilmes.entities.Filme;
import com.apiDeFilmes.entities.Genero;
import com.apiDeFilmes.entities.Roteirista;
import com.apiDeFilmes.repositories.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;
	
	public Filme find(Integer id) {
		Optional<Filme> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + Filme.class.getName()));
	}
	
	
	public Filme insert(Filme obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Filme update(Integer id, Filme obj) {
		Filme newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<Filme> findAll(){
		return repository.findAll();
	}
	
	public List<Filme> findByTitulo(String titulo){
		List<Filme> filmes = repository.findByTitulo(titulo);
		return filmes;
	}
	
	public List<Filme> findByGenero(Genero genero){
		List<Filme> filmes = repository.findByGenero(genero);
		return filmes;
	}
	
	public List<Filme> findByDiretor(Diretor diretor){
		List<Filme> filmes = repository.findByDiretor(diretor);
		return filmes;
	}
	
	public List<Filme> findByRoteirista(Roteirista roteirista){
		List<Filme> filmes = repository.findByRoteirista(roteirista);
		return filmes;
	}

	public List<Filme> findByAtor(Ator ator){
		List<Filme> filmes = repository.findByAtor(ator);
		return filmes;
	}
	
	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(Filme newObj, Filme obj) {
		newObj.setTitulo(obj.getTitulo());	
		newObj.setAno(obj.getAno());
		newObj.setDuracao(obj.getDuracao());
		newObj.setSinopse(obj.getSinopse());
		newObj.setFaixaEtaria(obj.getFaixaEtaria());
		newObj.setTrailerURL(obj.getTrailerURL());
		newObj.setImgPosterURL(obj.getImgPosterURL());
	}
}
