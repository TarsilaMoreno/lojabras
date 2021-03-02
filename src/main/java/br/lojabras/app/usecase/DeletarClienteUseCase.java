package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.service.ClienteService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeletarClienteUseCase {

	private final ClienteService service;
	
	public void execute(Long id) {
		service.deletar(id);
	}
}
