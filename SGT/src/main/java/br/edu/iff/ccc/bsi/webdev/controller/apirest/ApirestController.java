package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Usuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class ApirestController {

	@GetMapping(path = "/pessoa/{id}")
	public String getPessoa(@PathVariable("id") int id) {
		return "Pessoa id: " + id;
	}
	
	@PostMapping(path = "/pessoa")
	public Usuario addPessoa(@RequestBody Usuario entity) {
		//TODO: process POST request
		
		return entity;
	}
	
	
}
