package br.lojabras.app.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.lojabras.app.model.ClienteEntity;
import br.lojabras.app.model.EstoqueEntity;
import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

	private final ClienteRepository repository;

	public List<ClienteEntity> obterTodos() {
		return repository.findAll();
	}

	public void inserir(ClienteEntity cliente) {
		repository.save(cliente);

	}
	public ClienteEntity obterClientePorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Cliente_do_id_" + id + "_nao_encontrado", 1));
	}
	
	public void atualizar(ClienteEntity entity,ClienteDTO cliente) {
		entity.merge(cliente);
		repository.save(entity);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
