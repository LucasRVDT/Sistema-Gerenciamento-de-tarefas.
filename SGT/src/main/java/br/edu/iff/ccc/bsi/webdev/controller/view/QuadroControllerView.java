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

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;
import br.edu.iff.ccc.bsi.webdev.service.QuadroService;

@Controller
@RequestMapping("/quadros")
public class QuadroControllerView {

    @Autowired
    private QuadroService quadroService;

    @GetMapping
    public String listQuadros(Model model) {
        model.addAttribute("quadros", quadroService.findAll());
        return "quadros"; 
    }

    
    @GetMapping("/novo")
    public String showCreateForm(Model model) {
        Quadro quadro = new Quadro(); 
        model.addAttribute("quadro", quadro);
        return "form-quadro"; 
    }

    
    @PostMapping("/salvar")
    public String saveQuadro(@ModelAttribute("quadro") Quadro quadro) {
        quadroService.save(quadro); 
        return "redirect:/quadros"; 
    }

    
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Quadro> quadroOptional = quadroService.findById(id);
        if (quadroOptional.isPresent()) {
            model.addAttribute("quadro", quadroOptional.get());
            return "form-quadro"; 
        } else {
            return "redirect:/quadros"; 
        }
    }

    
    @PostMapping("/deletar/{id}")
    public String deleteQuadro(@PathVariable("id") Long id) {
        quadroService.deleteById(id); 
        return "redirect:/quadros"; 
    }
}
