package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;
import br.edu.iff.ccc.bsi.webdev.repository.QuadroRepository;

@Service
public class QuadroService {

    @Autowired
    private QuadroRepository quadroRepository;

public List<Quadro> findByNomeContaining(String nome) {
  return quadroRepository.findByNomeContaining(nome);
}

}
