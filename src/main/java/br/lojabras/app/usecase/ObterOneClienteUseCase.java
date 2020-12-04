package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.service.ClienteService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor

public class ObterOneClienteUseCase {
	
	private final ClienteService service;
	
	public ClienteDTO execute(Long id) {
		return service.obterClientePorId(id).toDTO();
	}


}
