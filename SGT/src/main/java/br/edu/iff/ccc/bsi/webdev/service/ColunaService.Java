package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.repository.ColunaRepository;

@Service
public class ColunaService {

    @Autowired
    private ColunaRepository colunaRepository;

    public List<Coluna> findByOrdemInQuadro(int ordem) {
      return colunaRepository.findByOrdemInQuadro(ordem);
  }
}
