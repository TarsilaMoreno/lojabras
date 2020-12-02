package br.lojabras.app.usecase;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.ClienteEntity;
import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.service.ClienteService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ObterTodosClientesUseCase {

	private final ClienteService service;

	public List<ClienteDTO> execute() {
		return service.
				obterTodos().
				stream().
				map(ClienteEntity::toDTO).
				collect(toList());
	}

}
