package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;


import br.lojabras.app.model.dto.VendasDTO;
import br.lojabras.app.service.VendasService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ObterOneVendaUseCase {
	
private final VendasService service;
	
	public VendasDTO execute(Long id) {
		return service.obterVendaPorId(id).toDTO();
	}

}
