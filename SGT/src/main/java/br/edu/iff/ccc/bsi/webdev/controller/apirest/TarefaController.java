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

import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;
import br.edu.iff.ccc.bsi.webdev.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping("/list")
	public List<Tarefa> getListTarefas() {
		return tarefaService.findAll();
	}

	@GetMapping("/id/{id}")
	public Optional<Tarefa> getTarefaById(@PathVariable Long id) {
		return tarefaService.findById(id);
	}
	
	@PostMapping("/save")
	public Object saveTarefa(@RequestBody Tarefa tarefa) {
		return tarefaService.save(tarefa);
	}

	@DeleteMapping("/delete")
	public void deleteTarefa(@PathVariable Long id) {
		tarefaService.deleteById(id);
	}
	
}
