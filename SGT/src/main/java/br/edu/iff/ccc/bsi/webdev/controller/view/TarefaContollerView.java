package br.edu.iff.ccc.bsi.webdev.controller.view;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;
import br.edu.iff.ccc.bsi.webdev.repository.TarefaRepository;

@Controller
@RequestMapping("/tarefas")
public class TarefaContollerView {

    @Autowired
    private TarefaRepository tarefaRepository;

    
    @GetMapping
    public String listTarefas(Model model) {
        model.addAttribute("tarefas", tarefaRepository.findAll());
        return "tarefas"; 
    }

    
    @GetMapping("/novo")
    public String showCreateForm(Model model) {
        Tarefa tarefa = new Tarefa(); 
        model.addAttribute("tarefa", tarefa);
        return "form-tarefa"; 
    }

    
    @PostMapping("/salvar")
    public String saveTarefa(@ModelAttribute("tarefa") Tarefa tarefa) {
        tarefaRepository.save(tarefa); 
        return "redirect:/tarefas"; 
    }

    
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            model.addAttribute("tarefa", tarefaOptional.get());
            return "form-tarefa"; 
        } else {
            return "redirect:/tarefas"; 
        }
    }

    
    @GetMapping("/deletar/{id}")
    public String deleteTarefa(@PathVariable("id") Long id) {
        tarefaRepository.deleteById(id); 
        return "redirect:/tarefas"; 
    }
}
