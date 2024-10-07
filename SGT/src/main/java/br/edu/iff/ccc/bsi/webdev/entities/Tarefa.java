package br.edu.iff.ccc.bsi.webdev.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "O campo titulo não pode ser nulo.")
	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Size(min = 5, max = 200, message = "A descricao deve ter entre 5 e 200 caracteres.")
	@Column(name = "descricao")
	private String descricao;

	@NotNull(message = "O campo data_criacao não pode ser nulo.")
	@Column(name = "data_criacao", nullable = false)
	private LocalDate dataCriacao;

	@NotNull(message = "O campo data_conclusao não pode ser nulo.")
	@Column(name = "data_conclusao")
	private LocalDate dataConclusao;

	@NotNull(message = "O campo prioridade não pode ser nulo.")
	@Column(name = "prioridade", nullable = false)
	private String prioridade;

	@NotNull(message = "O campo status não pode ser nulo.")
	@Column(name = "status", nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "coluna_id")
	private Coluna coluna;

	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	private Usuario responsavel;

	@OneToMany(mappedBy = "tarefa")
	private List<Anexo> anexos;

	// Getters and Setters
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Coluna getColuna() {
		return coluna;
	}

	public void setColuna(Coluna coluna) {
		this.coluna = coluna;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}


}
