package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.repository.ColunaRepository;

@Service
public class ColunaService {

    @Autowired
    private ColunaRepository colunaRepository;

    // CREATE
    public Coluna createColuna(Coluna coluna) {
        return colunaRepository.save(coluna);
    }

    // READ
    public Coluna findColunaById(Long id) {
        Optional<Coluna> optionalColuna = colunaRepository.findById(id);
        return optionalColuna.orElse(null);
    }
    
    // UPDATE
    public Coluna updateColuna(Long id, Coluna colunaDetails) {
        Optional<Coluna> optionalColuna = colunaRepository.findById(id);
        if (optionalColuna.isPresent()) {
            Coluna coluna = optionalColuna.get();
            coluna.setNome(colunaDetails.getNome());
            coluna.setOrdem(colunaDetails.getOrdem());
            coluna.setQuadro(colunaDetails.getQuadro());
            return colunaRepository.save(coluna);
        }
        return null;
    }

    // DELETE
    public void deleteColuna(Long id) {
        if (colunaRepository.existsById(id)) {
            colunaRepository.deleteById(id);
        }
    }

    public List<Coluna> findAllColunas() {
        return colunaRepository.findAll();
    }

    public List<Coluna> findByOrdemInQuadro(int ordem, Long quadroId) {
        return colunaRepository.findByOrdemInQuadro(ordem, quadroId);
    }

    public List<Coluna> findByNome(String nome) {
        return colunaRepository.findByNome(nome);
    }

    public List<Coluna> findByQuadroId(Long quadroId) {
        return colunaRepository.findByQuadroId(quadroId);
    }

}
