package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;


import br.lojabras.app.service.VendasService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeletarVendaUseCase {
	
	private final VendasService service;
	
	public void execute(Long id) {
		service.deletar(id);
	}

}
