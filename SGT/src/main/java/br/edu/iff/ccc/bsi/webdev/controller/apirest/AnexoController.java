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

import br.edu.iff.ccc.bsi.webdev.entities.Anexo;
import br.edu.iff.ccc.bsi.webdev.service.AnexoService;

@RestController
@RequestMapping("/anexo")
public class AnexoController {

	@Autowired
	private AnexoService anexoService;

	@GetMapping("/list")
	public List<Anexo> getListColina() {
		return anexoService.findAll();
	}

	@GetMapping("/id/{id}")
	public Optional<Anexo> getColunaById(@PathVariable Long id) {
		return anexoService.findById(id);
	}
	
	@PostMapping("/save")
	public Object saveColuna(@RequestBody Anexo anexo) {
		return anexoService.save(anexo);
	}

	@DeleteMapping("/delete")
	public void deleteColuna(@PathVariable Long id) {
		anexoService.deleteById(id);
	}
	
}
