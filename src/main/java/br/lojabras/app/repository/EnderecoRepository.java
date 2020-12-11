package br.lojabras.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.lojabras.app.model.EnderecoEntity;



public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long>{ 

}
