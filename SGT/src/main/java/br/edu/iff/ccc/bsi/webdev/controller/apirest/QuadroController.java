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

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;
import br.edu.iff.ccc.bsi.webdev.service.QuadroService;

@RestController
@RequestMapping("/quadro")
public class QuadroController {

	@Autowired
	private QuadroService quadroService;

	@GetMapping("/list")
	public List<Quadro> getListQuadros() {
		return quadroService.findAll();
	}

	@GetMapping("/id/{id}")
	public Optional<Quadro> getQUadroById(@PathVariable Long id) {
		return quadroService.findById(id);
	}
	
	@PostMapping("/save")
	public Object saveQuadro(@RequestBody Quadro quadro) {
		return quadroService.save(quadro);
	}

	@DeleteMapping("/delete")
	public void deleteQuadro(@PathVariable Long id) {
		quadroService.deleteById(id);
	}
	
}
