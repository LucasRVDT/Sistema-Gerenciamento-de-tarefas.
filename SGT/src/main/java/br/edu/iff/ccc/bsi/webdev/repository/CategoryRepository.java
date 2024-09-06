package br.edu.iff.ccc.bsi.webdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


import br.edu.iff.ccc.bsi.webdev.entities.Categoria;
import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;

@Repository
public interface CategoryRepository extends JpaRepository<Tarefa, Long>{

  @Query("SELECT c FROM Categoria c WHERE c.nome = :nome")
List<Categoria> findByNome(@Param("nome") String nome);

@Query("SELECT c FROM Categoria c WHERE c.nome = :descricao")
List<Categoria> findByDescricao(@Param("descricao") String descricao);

}
