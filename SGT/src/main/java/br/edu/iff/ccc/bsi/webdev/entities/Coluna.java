package br.edu.iff.ccc.bsi.webdev.entities;

import java.io.Serializable;
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


@SuppressWarnings("serial")
@Entity
@Table(name = "tb_coluna")
public class Coluna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@NotNull(message = "O campo nome não pode ser nulo.")
    @Column(name = "nome", nullable = false)
    private String nome;

	@NotNull(message = "O campo ordem não pode ser nulo.")
    @Column(name = "ordem", nullable = false)
    private int ordem;

    @ManyToOne
    @JoinColumn(name = "quadro_id")
    private Quadro quadro;

    @OneToMany(mappedBy = "coluna")
    private List<Tarefa> tarefas;
    
    
    // Getters and Setters
    
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
