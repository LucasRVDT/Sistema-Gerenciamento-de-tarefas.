package br.edu.iff.ccc.bsi.webdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.bsi.webdev.entities.Coluna;

@Repository
public interface ColunaRepository extends JpaRepository<Coluna, Long> {  
    
    @Query("SELECT c FROM Coluna c WHERE c.ordem = ?1 AND c.quadro.id = ?2")
    List<Coluna> findByOrdemInQuadro(int ordem, Long quadroId);
    
    @Query("SELECT c FROM Coluna c WHERE c.nome = ?1")
    List<Coluna> findByNome(String nome);

    @Query("SELECT c FROM Coluna c WHERE c.quadro.id = ?1")
    List<Coluna> findByQuadroId(Long quadroId);
}
