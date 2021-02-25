package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.service.ClienteService;
import br.lojabras.app.validation.ClienteCadastroValidator;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InserirClienteUseCase {

	private final ClienteService service;
	private final ClienteCadastroValidator validator;
	
	public ClienteDTO execute(ClienteDTO cadastro) {
		validator.validate(cadastro);
		service.inserir(cadastro.toEntity());
		return cadastro;
	}
}
