package br.edu.iff.ccc.bsi.webdev.mapper;

import java.time.LocalDate;
import java.util.List;

import br.edu.iff.ccc.bsi.webdev.entities.Anexo;
import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;

public class TarefaModel {
	Long id;
	String titulo;
	String descricao;
	LocalDate dataCriacao;
	LocalDate dataConclusao;
	String prioridade;
	String status;
	Coluna coluna;
	Usuario responsavel;
	List<Anexo> anexos;
}
