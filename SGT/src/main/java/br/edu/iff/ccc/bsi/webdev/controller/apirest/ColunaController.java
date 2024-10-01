package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.service.ColunaService;

@RestController
@RequestMapping("/v01/coluna")
public class ColunaController {

	@Autowired
	private ColunaService colunaService;

	@GetMapping("/list")
	public List<Coluna> getListColina() {
		return colunaService.findAllColunas();
	}

	@GetMapping("/id/{id}")
	public Optional<Coluna> getColunaById(@PathVariable Long id) {
		return colunaService.findColunaById(id);
	}
	
	@PostMapping("/save")
	public Object saveColuna(@RequestBody Coluna coluna) {
		return colunaService.createColuna(coluna);
	}

	@DeleteMapping("/delete")
	public void deleteColuna(@PathVariable Long id) {
		colunaService.deleteColuna(id);
	}
	
}
