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

import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.repository.UsuarioRepository;
import br.edu.iff.ccc.bsi.webdev.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControllerView {

    @Autowired
    //private UsuarioRepository usuarioRepository;
    
    private UsuarioService usuarioService;

    @GetMapping
    public String listUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuarios";
    }

    @GetMapping("/novo")
    public String showCreateForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "form-usuario";
    }

    @PostMapping("/salvar")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
    	usuarioService.save(usuario);
        return "redirect:/usuarios";
    }


    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            model.addAttribute("usuario", usuarioOptional.get());
            return "form-usuario";
        } else {
            return "redirect:/usuarios";
        }
    }
    
    @PostMapping("/atualizar/{id}")
    public String updateUsuario(@PathVariable("id") Long id, @ModelAttribute("usuario") Usuario usuario) {
        if (!id.equals(usuario.getId())) {
            return "redirect:/usuarios"; 
        }
        usuarioService.save(usuario); 
        return "redirect:/usuarios"; 
    }

    
    @PostMapping("/excluir/{id}")
    public String deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);
        return "redirect:/usuarios";
    }

}
