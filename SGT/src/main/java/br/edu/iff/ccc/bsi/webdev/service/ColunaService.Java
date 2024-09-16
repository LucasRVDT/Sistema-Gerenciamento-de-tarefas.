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

    public Coluna createColuna(Coluna coluna) {
        return colunaRepository.save(coluna);
    }

    public Optional<Coluna> findColunaById(Long id) {
        return colunaRepository.findById(id);
    }

    public void deleteColuna(Long id) {
        colunaRepository.deleteById(id);
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
