package br.lojabras.app.usecase;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.FornecedorEntity;
import br.lojabras.app.model.dto.FornecedorDTO;
import br.lojabras.app.service.FornecedorService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ObterTodosFornecedorUseCase {
	
	private final FornecedorService service;

	public List<FornecedorDTO> execute() {
		return service.obterTodos().
				stream().
				map(FornecedorEntity::toDTO).
				collect(toList());
	}

}
