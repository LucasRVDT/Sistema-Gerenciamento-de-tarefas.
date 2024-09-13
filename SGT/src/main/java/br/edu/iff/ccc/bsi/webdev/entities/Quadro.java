package br.edu.iff.ccc.bsi.webdev.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@SuppressWarnings("serial")
@Entity
@Table(name = "tb_quadro")
public class Quadro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

		@NotNull(message = "O campo nome não pode ser nulo.")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(min = 5, max = 200, message = "A descricao deve ter entre 5 e 200 caracteres.")
    @Column(name = "descricao")
    private String descricao;

		@NotNull(message = "O campo data_criacao não pode ser nulo.")
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

		@NotNull(message = "O campo status não pode ser nulo.")
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "quadro")
    private List<Coluna> colunas;

    @ManyToMany
    @JoinTable(name = "quadro_membros", 
              joinColumns = @JoinColumn(name = "quadro_id"), 
              inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> membros;

    // Getters and Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Coluna> getColunas() {
		return colunas;
	}

	public void setColunas(List<Coluna> colunas) {
		this.colunas = colunas;
	}

	public List<Usuario> getMembros() {
		return membros;
	}

	public void setMembros(List<Usuario> membros) {
		this.membros = membros;
	}


}
