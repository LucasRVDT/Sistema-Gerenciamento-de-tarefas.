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

    // Listar todas as tarefas (Read)
    @GetMapping
    public String listTarefas(Model model) {
        model.addAttribute("tarefas", tarefaRepository.findAll());
        return "tarefas"; // Nome da página Thymeleaf para exibir as tarefas
    }

    // Exibir o formulário de criação de uma nova tarefa (Create)
    @GetMapping("/novo")
    public String showCreateForm(Model model) {
        Tarefa tarefa = new Tarefa(); // Cria uma nova instância de Tarefa
        model.addAttribute("tarefa", tarefa);
        return "form-tarefa"; // Nome da página Thymeleaf para o formulário
    }

    // Criar ou atualizar uma tarefa (Create/Update)
    @PostMapping("/salvar")
    public String saveTarefa(@ModelAttribute("tarefa") Tarefa tarefa) {
        tarefaRepository.save(tarefa); // Salva ou atualiza a tarefa
        return "redirect:/tarefas"; // Redireciona para a lista de tarefas
    }

    // Exibir o formulário de edição de uma tarefa existente (Update)
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            model.addAttribute("tarefa", tarefaOptional.get());
            return "form-tarefa"; // Nome da página Thymeleaf para o formulário de edição
        } else {
            return "redirect:/tarefas"; // Redireciona caso a tarefa não seja encontrada
        }
    }

    // Deletar uma tarefa (Delete)
    @GetMapping("/deletar/{id}")
    public String deleteTarefa(@PathVariable("id") Long id) {
        tarefaRepository.deleteById(id); // Deleta a tarefa pelo ID
        return "redirect:/tarefas"; // Redireciona para a lista de tarefas
    }
}
