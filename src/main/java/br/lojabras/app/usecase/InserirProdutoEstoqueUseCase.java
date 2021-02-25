package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.service.EstoqueService;
import br.lojabras.app.validation.EstoqueProdutoValidator;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InserirProdutoEstoqueUseCase {

	private final EstoqueService service;

	private final EstoqueProdutoValidator validator;

	public EstoqueDTO execute(EstoqueDTO produto) {
		validator.validate(produto);
		service.inserir(produto.toEntity());
		return produto;
	}

}
