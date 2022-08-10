package com.apiDeFilmes.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiDeFilmes.entities.Ator;
import com.apiDeFilmes.services.AtorService;

@RestController
@RequestMapping(value = "/atores")
public class AtorResource {

	@Autowired
	private AtorService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Ator ator = service.find(id);
		
		return ResponseEntity.ok().body(ator);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Ator ator){
		
		ator = service.insert(ator);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ator.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Ator ator, @PathVariable Integer id){
		
		ator.setId(id);
		
		ator = service.update(id, ator);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
