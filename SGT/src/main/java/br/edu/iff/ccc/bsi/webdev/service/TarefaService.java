package br.edu.iff.ccc.bsi.webdev.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;
import br.edu.iff.ccc.bsi.webdev.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    // Método para buscar tarefas por status
    public List<Tarefa> findTarefasByStatus(String status) {
        return tarefaRepository.findByStatus(status);
    }

// Método para buscar tarefas criadas deppois de determinada data
    public List<Tarefa> findTarefasCreatedAfter(LocalDate data) {
      return tarefaRepository.findTarefasCreatedAfter(data);
  }
}