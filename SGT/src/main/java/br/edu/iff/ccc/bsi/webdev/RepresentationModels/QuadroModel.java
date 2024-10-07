package br.edu.iff.ccc.bsi.webdev.RepresentationModels;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.hateoas.RepresentationModel;
import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;

public class QuadroModel extends RepresentationModel<QuadroModel> {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataCriacao;
    private String status;
    private Usuario usuario;
    private List<Coluna> colunas;
    private List<Usuario> membros;

    // Construtor
    public QuadroModel(Long id, String nome, String descricao, LocalDateTime dataCriacao, String status, Usuario usuario, List<Coluna> colunas, List<Usuario> membros) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.usuario = usuario;
        this.colunas = colunas;
        this.membros = membros;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Coluna> getColunas() {
        return colunas;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

}
