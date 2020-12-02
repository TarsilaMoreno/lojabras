package br.lojabras.app.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.ClienteEntity;
import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.service.EstoqueService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ObterOneEstoqueUseCase {
	
	private final EstoqueService service;
	
	public List<ClienteDTO> execute1() {
		return service.
				obterOne().
				stream().
				map(ClienteEntity::toDTO).
				collect(toList());
	}

	
}
