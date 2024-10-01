package br.edu.iff.ccc.bsi.webdev.RepresentationModels;

import org.springframework.hateoas.RepresentationModel;

import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;

public class AnexoModel extends RepresentationModel<AnexoModel> {

	Long id;
	String nome;
	String url;
	String tipo;
	Tarefa tarefa;
	
}
