package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.ClienteEntity;

import br.lojabras.app.model.dto.ClienteDTO;

import br.lojabras.app.service.ClienteService;
import br.lojabras.app.validation.ClienteCadastroValidator;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AtualizarClienteUseCase {
	
	private final ClienteService service;

	private final ClienteCadastroValidator validator;

	public ClienteDTO execute(Long id, ClienteDTO cliente) {
		validator.validate(cliente);
		ClienteEntity entity = service.obterClientePorId(id);
		service.atualizar(entity, cliente);
		return entity.toDTO();

	}
}