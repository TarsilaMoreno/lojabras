package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.service.EstoqueService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InserirProdutoEstoqueUseCase {

	private final EstoqueService service;

	public EstoqueDTO execute(EstoqueDTO produto) {
		service.inserir(produto.toEntity());
		return produto;
	}

}
