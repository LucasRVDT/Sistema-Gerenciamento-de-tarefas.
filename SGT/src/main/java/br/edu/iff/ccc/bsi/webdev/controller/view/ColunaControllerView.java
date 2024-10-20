package br.edu.iff.ccc.bsi.webdev.controller.view;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.repository.ColunaRepository;
import br.edu.iff.ccc.bsi.webdev.service.ColunaService;
import br.edu.iff.ccc.bsi.webdev.service.QuadroService;

@Controller
@RequestMapping("/colunas")
public class ColunaControllerView {

    @Autowired
    private ColunaService colunaService;

    @Autowired
    private QuadroService quadroService; 

    @GetMapping
    public String listColunas(Model model) {
        model.addAttribute("colunas", colunaService.findAllColunas());
        return "colunas";
    }

    @GetMapping("/novo")
    public String showCreateForm(Model model) {
        Coluna coluna = new Coluna();
        model.addAttribute("coluna", coluna);
        model.addAttribute("quadros", quadroService.findAll());
        return "form-coluna";
    }

    @PostMapping("/salvar")
    public String saveColuna(@ModelAttribute("coluna") Coluna coluna) {
        colunaService.createColuna(coluna);
        return "redirect:/colunas";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Coluna> colunaOptional = colunaService.findColunaById(id);
        if (colunaOptional.isPresent()) {
            model.addAttribute("coluna", colunaOptional.get());
            model.addAttribute("quadros", quadroService.findAll());
            return "form-coluna"; 
        } else {
            return "redirect:/colunas";
        }
    }

    @PostMapping("/atualizar/{id}")
    public String updateColuna(@PathVariable("id") Long id, @ModelAttribute("coluna") Coluna coluna) {
        if (!id.equals(coluna.getId())) {
            return "redirect:/colunas"; 
        }
        colunaService.createColuna(coluna);
        return "redirect:/colunas"; 
    }

    @DeleteMapping("/deletar/{id}")
    public String deleteColuna(@PathVariable("id") Long id) {
        colunaService.deleteColuna(id); 
        return "redirect:/colunas"; 
    }
}

