package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Anexo;
import br.edu.iff.ccc.bsi.webdev.repository.AnexoRepository;

@Service
public class AnexoService {

    @Autowired
    private AnexoRepository anexoRepository;

    public List<Anexo> findAnexosByTarefa(Long tarefaId) {
      return anexoRepository.findByTarefa(tarefaId);
  }

}
