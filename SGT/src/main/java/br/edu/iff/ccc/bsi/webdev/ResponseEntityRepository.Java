package br.edu.iff.ccc.bsi.webdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ResponseEntityRepository extends JpaRepository <ResponseEntity, String>{


}
