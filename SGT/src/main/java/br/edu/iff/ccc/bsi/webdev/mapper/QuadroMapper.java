package br.edu.iff.ccc.bsi.webdev.mapper;

import br.edu.iff.ccc.bsi.webdev.RepresentationModels.QuadroModel;
import br.edu.iff.ccc.bsi.webdev.controller.apirest.QuadroController;
import br.edu.iff.ccc.bsi.webdev.entities.Quadro;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class QuadroMapper {

    public static QuadroModel toModel(Quadro quadro) {
        QuadroModel model = new QuadroModel(
                quadro.getId(),
                quadro.getNome(),
                quadro.getDescricao(),
                quadro.getDataCriacao(),
                quadro.getStatus(),
                quadro.getUsuario(),
                quadro.getColunas(),
                quadro.getMembros()
        );

        // Adiciona o link HATEOAS
        model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(QuadroController.class).getQuadroById(quadro.getId())).withSelfRel());

        return model;
    }
}
