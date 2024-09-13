package br.edu.iff.ccc.bsi.webdev.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;
import br.edu.iff.ccc.bsi.webdev.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    // CRUD
    public List<Tarefa> findAllTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> findTarefaById(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa saveTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa updateTarefa(Long id, Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        
        if (tarefaOptional.isPresent()) {
            Tarefa tarefa = tarefaOptional.get();
            tarefa.setTitulo(tarefaAtualizada.getTitulo());
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setStatus(tarefaAtualizada.getStatus());
            tarefa.setDataCriacao(tarefaAtualizada.getDataCriacao());
            return tarefaRepository.save(tarefa);
        }
        
        throw new EntityNotFoundException("Tarefa com ID " + id + " não encontrada.");
    }

    public void deleteTarefa(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Tarefa com ID " + id + " não encontrada.");
        }
    }

    // Método para buscar tarefas por status
    public List<Tarefa> findTarefasByStatus(String status) {
        return tarefaRepository.findByStatus(status);
    }

// Método para buscar tarefas criadas deppois de determinada data
    public List<Tarefa> findTarefasCreatedAfter(LocalDate data) {
      return tarefaRepository.findTarefasCreatedAfter(data);
  }
}



