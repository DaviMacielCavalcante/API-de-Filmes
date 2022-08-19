package com.apiDeFilmes.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiDeFilmes.entities.Filmes;
import com.apiDeFilmes.services.FilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeResource {

	@Autowired
	private FilmeService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Filmes filme = service.find(id);
		
		return ResponseEntity.ok().body(filme);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		
		List<Filmes> filme = service.findAll();
		
		return ResponseEntity.ok().body(filme);
		
	}
	
	@RequestMapping(value = "/titulo/{titulo}", method = RequestMethod.GET)
	public ResponseEntity<?> findByTitulo(@PathVariable String titulo){
		
		List<Filmes> filme = service.findByTitulo(titulo);
		
		return ResponseEntity.ok().body(filme);
		
	}
	
	@RequestMapping(value = "/genero/{genero}", method = RequestMethod.GET)
	public ResponseEntity<?> findByGenero(@PathVariable String genero){
		
		List<Filmes> filme = service.findByTitulo(genero);
		
		return ResponseEntity.ok().body(filme);
		
	}
	
	@RequestMapping(value = "/diretor/{diretor}", method = RequestMethod.GET)
	public ResponseEntity<?> findByDiretor(@PathVariable String diretor){
		
		List<Filmes> filme = service.findByTitulo(diretor);
		
		return ResponseEntity.ok().body(filme);
		
	}
	
	@RequestMapping(value = "/rotei/{rotei}", method = RequestMethod.GET)
	public ResponseEntity<?> findByRoteirista(@PathVariable String rotei){
		
		List<Filmes> filme = service.findByTitulo(rotei);
		
		return ResponseEntity.ok().body(filme);
		
	}
	
	@RequestMapping(value = "/ator/{ator}", method = RequestMethod.GET)
	public ResponseEntity<?> findByAtor(@PathVariable String ator){
		
		List<Filmes> filme = service.findByTitulo(ator);
		
		return ResponseEntity.ok().body(filme);
		
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Filmes filme){
		
		filme = service.insert(filme);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filme.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Filmes filme, @PathVariable Integer id){
		
		filme.setId(id);
		
		filme = service.update(id, filme);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}