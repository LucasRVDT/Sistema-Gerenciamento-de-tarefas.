package br.edu.iff.ccc.bsi.webdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;

@Repository
public interface QuadroRepository extends JpaRepository<Quadro, Long> {
    
    @Query("SELECT q FROM Quadro q WHERE q.nome LIKE %?1%")
    List<Quadro> findByNomeContaining(String nome);
    
    @Query("SELECT q FROM Quadro q WHERE q.usuario.id = ?1")
    List<Quadro> findByUsuarioId(Long id);
}
