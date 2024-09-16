package br.edu.iff.ccc.bsi.webdev.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;
import br.edu.iff.ccc.bsi.webdev.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    // CRUD
    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> findById(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa save(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void deleteById(Long id) {
            tarefaRepository.deleteById(id);
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



