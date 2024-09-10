package br.edu.iff.ccc.bsi.webdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

  @Query("SELECT t FROM Tarefa t WHERE t.status = :status")
List<Tarefa> findByStatus(@Param("status") String status);

@Query("SELECT t FROM Tarefa t WHERE t.dataCriacao > :data")
List<Tarefa> findTasksCreatedAfter(@Param("data") LocalDate data);

}
