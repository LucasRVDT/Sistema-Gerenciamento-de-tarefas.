package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;
import br.edu.iff.ccc.bsi.webdev.repository.QuadroRepository;

@Service
public class QuadroService {

    @Autowired
    private QuadroRepository quadroRepository;

    public Quadro save(Quadro quadro) {
        return quadroRepository.save(quadro);
    }

    public Optional<Quadro> findById(Long id) {
        return quadroRepository.findById(id);
    }
    
    public List<Quadro> findByNomeContaining(String nome) {
    	return quadroRepository.findByNomeContaining(nome);
    }

    public List<Quadro> findAll() {
        return quadroRepository.findAll();
    }

    public void deleteById(Long id) {
        quadroRepository.deleteById(id);
    }

    public List<Quadro> findByUsuarioId(Long usuarioId) {
        return quadroRepository.findByUsuarioId(usuarioId);
    }
}
