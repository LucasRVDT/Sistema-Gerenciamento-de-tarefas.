package br.edu.iff.ccc.bsi.webdev.RepresentationModels;

import org.springframework.hateoas.RepresentationModel;
import br.edu.iff.ccc.bsi.webdev.entities.Quadro;
import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;

import java.util.List;

public class ColunaModel extends RepresentationModel<ColunaModel> {
    private Long id;
    private String nome;
    private int ordem;
    private Quadro quadro;
    private List<Tarefa> tarefas;

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

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
