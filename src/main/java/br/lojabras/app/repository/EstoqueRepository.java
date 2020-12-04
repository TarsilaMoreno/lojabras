package br.lojabras.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.lojabras.app.model.EstoqueEntity;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long>{

	

	

}
