package br.lojabras.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.lojabras.app.model.ClienteEntity;
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
}
