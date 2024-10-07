package br.edu.iff.ccc.bsi.webdev.mapper;

import br.edu.iff.ccc.bsi.webdev.entities.Anexo;
import br.edu.iff.ccc.bsi.webdev.RepresentationModels.AnexoModel;
import br.edu.iff.ccc.bsi.webdev.controller.apirest.AnexoController;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class AnexoMapper {

    public AnexoModel toModel(Anexo anexo) {
        AnexoModel anexoModel = new AnexoModel();
        anexoModel.setId(anexo.getId());
        anexoModel.setNome(anexo.getNome());
        anexoModel.setUrl(anexo.getUrl());
        anexoModel.setTipo(anexo.getTipo());
        anexoModel.setTarefa(anexo.getTarefa());

        // Adicionando links HATEOAS
        WebMvcLinkBuilder linkToAnexo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AnexoController.class).getColunaById(anexo.getId()));
        anexoModel.add(linkToAnexo.withSelfRel());

        return anexoModel;
    }
}
