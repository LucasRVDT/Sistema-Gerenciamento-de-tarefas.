package br.edu.iff.ccc.bsi.webdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.bsi.webdev.entities.Anexo;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {
    
    @Query("SELECT a FROM Anexo a WHERE a.tarefa.id = ?1")
    List<Anexo> findByTarefa(Long tarefaId);
}
