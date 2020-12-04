package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.service.FornecedorService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor

public class DeletarFornecedorUseCase {

	private final FornecedorService service;

	public void execute(Long id) {
		service.deletar(id);
	}
}