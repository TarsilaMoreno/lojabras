package br.lojabras.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.lojabras.app.model.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
