package br.lojabras.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.lojabras.app.model.VendasEntity;

public interface VendasRepository extends JpaRepository<VendasEntity, Long> {

}
