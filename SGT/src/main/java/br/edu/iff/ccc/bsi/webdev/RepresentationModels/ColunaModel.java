package br.edu.iff.ccc.bsi.webdev.RepresentationModels;

import org.springframework.hateoas.RepresentationModel;

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;

import java.util.List;

import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;

public class ColunaModel extends RepresentationModel<ColunaModel> {
    Long id;
    String nome;
    int ordem;
    Quadro quadro;
    List<Tarefa> tarefas;
}

