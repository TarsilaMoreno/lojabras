package br.lojabras.app.service;

import java.util.List;

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
	
//	public EstoqueDTO atualizarEstoqueEntity () {
//		return repository.findById(id);
//	}
	
	public void deletar(EstoqueEntity estoque) {
		repository.save(estoque);
	}

	public List<EstoqueEntity> obterOne() {
		return repository.findOne();
	}
}