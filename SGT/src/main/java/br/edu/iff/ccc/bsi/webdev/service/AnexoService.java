package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Anexo;
import br.edu.iff.ccc.bsi.webdev.repository.AnexoRepository;

@Service
public class AnexoService {

    @Autowired
    private AnexoRepository anexoRepository;

    public Anexo save(Anexo anexo) {
        return anexoRepository.save(anexo);
    }

    public Optional<Anexo> findById(Long id) {
        return anexoRepository.findById(id);
    }

    public List<Anexo> findAll() {
        return anexoRepository.findAll();
    }

    public void deleteById(Long id) {
        anexoRepository.deleteById(id);
    }

    public List<Anexo> findByTarefa(Long tarefaId) {
        return anexoRepository.findByTarefa(tarefaId);
    }
}
