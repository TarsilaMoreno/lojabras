package br.lojabras.app.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.lojabras.app.model.EstoqueEntity;
import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.repository.EstoqueRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstoqueService {

	private final EstoqueRepository repository;

	public List<EstoqueEntity> obterTodos() {
		return repository.findAll();
	}

	public void inserir(EstoqueEntity estoque) {
		repository.save(estoque);
	}
	
	public void atualizar(EstoqueEntity entity,EstoqueDTO produto) {
		entity.merge(produto);
		repository.save(entity);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

	public EstoqueEntity obterProdutoPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Produto_de_id_" + id + "_nao_encontrado", 1));
	}
}