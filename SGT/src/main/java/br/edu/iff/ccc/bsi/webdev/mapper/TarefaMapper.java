package br.edu.iff.ccc.bsi.webdev.mapper;

import br.edu.iff.ccc.bsi.webdev.RepresentationModels.TarefaModel;
import br.edu.iff.ccc.bsi.webdev.controller.apirest.TarefaController;
import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class TarefaMapper {

    public static TarefaModel toModel(Tarefa tarefa) {
        TarefaModel model = new TarefaModel();
        model.setId(tarefa.getId());
        model.setTitulo(tarefa.getTitulo());
        model.setDescricao(tarefa.getDescricao());
        model.setDataCriacao(tarefa.getDataCriacao());
        model.setDataConclusao(tarefa.getDataConclusao());
        model.setPrioridade(tarefa.getPrioridade());
        model.setStatus(tarefa.getStatus());
        model.setColuna(tarefa.getColuna());
        model.setResponsavel(tarefa.getResponsavel());
        model.setAnexos(tarefa.getAnexos());

        // Adiciona o link HATEOAS
        model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TarefaController.class).findById(tarefa.getId())).withSelfRel());

        return model;
    }
}
