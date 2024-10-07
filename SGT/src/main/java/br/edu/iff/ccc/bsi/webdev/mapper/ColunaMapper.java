package br.edu.iff.ccc.bsi.webdev.mapper;

import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.RepresentationModels.ColunaModel;
import br.edu.iff.ccc.bsi.webdev.controller.apirest.ColunaController;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class ColunaMapper {

    public ColunaModel toModel(Coluna coluna) {
        ColunaModel colunaModel = new ColunaModel();
        colunaModel.setId(coluna.getId());
        colunaModel.setNome(coluna.getNome());
        colunaModel.setOrdem(coluna.getOrdem());
        colunaModel.setQuadro(coluna.getQuadro());
        colunaModel.setTarefas(coluna.getTarefas());

        // Adicionando links HATEOAS
        WebMvcLinkBuilder linkToColuna = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ColunaController.class).getColunaById(coluna.getId()));
        colunaModel.add(linkToColuna.withSelfRel());

        return colunaModel;
    }
}
