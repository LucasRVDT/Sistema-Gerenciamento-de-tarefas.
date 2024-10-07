package br.edu.iff.ccc.bsi.webdev.RepresentationModels;

import org.springframework.hateoas.RepresentationModel;
import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;

public class AnexoModel extends RepresentationModel<AnexoModel> {

    private Long id;
    private String nome;
    private String url;
    private String tipo;
    private Tarefa tarefa;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
}
