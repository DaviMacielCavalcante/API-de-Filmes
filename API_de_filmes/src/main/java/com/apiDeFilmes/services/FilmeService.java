package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Ator;
import com.apiDeFilmes.entities.Diretor;
import com.apiDeFilmes.entities.Filmes;
import com.apiDeFilmes.entities.Genero;
import com.apiDeFilmes.entities.Roteirista;
import com.apiDeFilmes.repositories.FilmesRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmesRepository repository;
	
	public Filmes find(Integer id) {
		Optional<Filmes> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + Filmes.class.getName()));
	}
	
	
	public Filmes insert(Filmes obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Filmes update(Integer id, Filmes obj) {
		Filmes newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<Filmes> findAll(){
		return repository.findAll();
	}
	
	public List<Filmes> findByTitulo(String titulo){
		List<Filmes> filmes = repository.findByTitulo(titulo);
		return filmes;
	}
	
	public List<Filmes> findByGenero(Genero genero){
		List<Filmes> filmes = repository.findByGenero(genero);
		return filmes;
	}
	
	public List<Filmes> findByDiretor(Diretor diretor){
		List<Filmes> filmes = repository.findByDiretor(diretor);
		return filmes;
	}
	
	public List<Filmes> findByRoteirista(Roteirista roteirista){
		List<Filmes> filmes = repository.findByRoteirista(roteirista);
		return filmes;
	}

	public List<Filmes> findByAtor(Ator ator){
		List<Filmes> filmes = repository.findByAtor(ator);
		return filmes;
	}
	
	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(Filmes newObj, Filmes obj) {
		newObj.setTitulo(obj.getTitulo());	
		newObj.setAno(obj.getAno());
		newObj.setDuracao(obj.getDuracao());
		newObj.setSinopse(obj.getSinopse());
		newObj.setFaixaEtaria(obj.getFaixaEtaria());
		newObj.setTrailerURL(obj.getTrailerURL());
		newObj.setImgPosterURL(obj.getImgPosterURL());
	}
}
