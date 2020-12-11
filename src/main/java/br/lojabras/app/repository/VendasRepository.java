package br.lojabras.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.lojabras.app.model.VendasEntity;

public interface VendasRepository extends JpaRepository<VendasEntity, Long> {

	public List<VendasEntity> findByStatus(String status);
}
