package br.edu.iff.ccc.bsi.webdev.RepresentationModels;

import java.time.LocalDate;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import br.edu.iff.ccc.bsi.webdev.entities.Anexo;
import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;

public class TarefaModel extends RepresentationModel<TarefaModel> {
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
