package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.service.EstoqueService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeletarProdutoUseCase {
	
	private final EstoqueService service;
	
	public void execute(Long id) {
		service.deletar(id);
	}
	
}
