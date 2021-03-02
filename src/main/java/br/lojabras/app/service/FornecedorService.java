package br.lojabras.app.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import br.lojabras.app.model.FornecedorEntity;
import br.lojabras.app.model.dto.FornecedorDTO;
import br.lojabras.app.repository.FornecedorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FornecedorService {

	private final FornecedorRepository repository;

	public void inserir(FornecedorEntity fornecedor) {
		repository.save(fornecedor);
	}

	public List<FornecedorEntity> obterTodos() {
		return repository.findAll();

	}
	public FornecedorEntity obterFornecedorPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Fornecedor" + id + "_nao_encontrado", 1));
	}
	
	public void atualizar(FornecedorEntity entity,FornecedorDTO cadastro) {
		entity.merge(cadastro);
		repository.save(entity);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
