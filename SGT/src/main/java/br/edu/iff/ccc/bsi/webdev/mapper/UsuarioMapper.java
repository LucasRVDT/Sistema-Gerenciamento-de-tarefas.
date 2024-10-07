package br.edu.iff.ccc.bsi.webdev.mapper;

import br.edu.iff.ccc.bsi.webdev.RepresentationModels.UsuarioModel;
import br.edu.iff.ccc.bsi.webdev.controller.apirest.UsuarioController;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class UsuarioMapper {

    public static UsuarioModel toModel(Usuario usuario) {
        UsuarioModel model = new UsuarioModel(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getQuadros()
        );

        // Adiciona o link HATEOAS
        model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).findById(usuario.getId())).withSelfRel());

        return model;
    }
}
