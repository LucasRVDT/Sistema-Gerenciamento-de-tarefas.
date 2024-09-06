package br.edu.iff.ccc.bsi.webdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import br.edu.iff.ccc.bsi.webdev.entities.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

  @Query( "SELECT u FROM Usuario u WHERE user.username = :username")
List<Usuario> findByUsername(@Param("username") String username);

@Query( "SELECT u FROM Usuario u WHERE user.email = :email")
List<Usuario> findByEmail(@Param("email") String email);

}
