package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.EstoqueEntity;
import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.service.EstoqueService;
import br.lojabras.app.validation.EstoqueProdutoValidator;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AtualizarTodosEstoqueUseCase {

	private final EstoqueService service;
	
	private final EstoqueProdutoValidator validator;

	public EstoqueDTO execute(Long id,EstoqueDTO produto) {
		validator.validate(produto);
		EstoqueEntity entity = service.obterProdutoPorId(id);
		service.atualizar(entity,produto);
		return entity.toDTO();
	}
		
}
