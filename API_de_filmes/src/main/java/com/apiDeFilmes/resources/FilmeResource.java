package com.apiDeFilmes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiDeFilmes.entities.Ator;
import com.apiDeFilmes.entities.Diretor;
import com.apiDeFilmes.entities.Filmes;
import com.apiDeFilmes.entities.Genero;
import com.apiDeFilmes.entities.Roteirista;
import com.apiDeFilmes.services.AtorService;
import com.apiDeFilmes.services.DiretorService;
import com.apiDeFilmes.services.FilmeService;
import com.apiDeFilmes.services.GeneroService;
import com.apiDeFilmes.services.RoteiristaService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeResource {

	@Autowired
	private FilmeService service;
	
	@Autowired
	private DiretorService dirServ;	
	
	@Autowired
	private GeneroService gerServ;
	
	@Autowired
	private RoteiristaService roteiristaService;
	
	@Autowired
	private AtorService atorService;
	
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
	
	@RequestMapping(value = "/genero/" ,method = RequestMethod.GET)
	public ResponseEntity<?> findByGenero(@RequestParam(value = "genero", defaultValue = "") String genero){
		
		Genero generoe = gerServ.findByNome(genero);
		
		List<Filmes> filme = service.findByGenero(generoe);
		
		return ResponseEntity.ok().body(filme);
		
	}
	
	@RequestMapping(value = "/diretor/", method = RequestMethod.GET)
	public ResponseEntity<?> findByDiretor(@RequestParam(value = "diretor", defaultValue = "") String diretor){
		
		Diretor diretore = dirServ.findByNome(diretor);
		
		List<Filmes> filme = service.findByDiretor(diretore);
		
		return ResponseEntity.ok().body(filme);
		
	}
	
	@RequestMapping(value = "/rotei/", method = RequestMethod.GET)
	public ResponseEntity<?> findByRoteirista(@RequestParam String rotei){
		
		Roteirista roti = roteiristaService.findByNome(rotei);
		
		List<Filmes> filme = service.findByRoteirista(roti);
		
		return ResponseEntity.ok().body(filme);
		
	}
	
	@RequestMapping(value = "/ator/{ator}", method = RequestMethod.GET)
	public ResponseEntity<?> findByAtor(@RequestParam String ator){
		
		Ator atores = atorService.findByNome(ator);
		
		List<Filmes> filme = service.findByAtor(atores);
		
		return ResponseEntity.ok().body(filme);
		
	}		
}
