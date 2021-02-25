package br.lojabras.app.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.lojabras.app.model.VendasEntity;

import br.lojabras.app.model.dto.VendasDTO;
import br.lojabras.app.repository.VendasRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VendasService {
	
	private final VendasRepository repository;
	
	public void inserir(VendasEntity venda) {
		repository.save(venda);
	}
	public List<VendasEntity> obterTodas() {
		return repository.findAll();
	}
	public void atualizar(VendasEntity entity,VendasDTO venda) {
		entity.merge(venda);
		repository.save(entity);
	}

	public VendasEntity obterVendaPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Venda_de_id_" + id + "_nao_encontrado", 1));
	}
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}

