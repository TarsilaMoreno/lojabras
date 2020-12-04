package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.service.EstoqueService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ObterOneEstoqueUseCase {
	
	private final EstoqueService service;
	
	public EstoqueDTO execute(Long id) {
		return service.obterProdutoPorId(id).toDTO();
	}

	
}
