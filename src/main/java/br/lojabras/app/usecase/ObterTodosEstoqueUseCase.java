package br.lojabras.app.usecase;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.EstoqueEntity;
import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.service.EstoqueService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ObterTodosEstoqueUseCase {

	private final EstoqueService service;

	public List<EstoqueDTO> execute() {
		return service.obterTodos().stream().map(EstoqueEntity::toDTO).collect(toList());
	}

}
