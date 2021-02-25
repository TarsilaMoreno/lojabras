package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;


import br.lojabras.app.model.VendasEntity;

import br.lojabras.app.model.dto.VendasDTO;

import br.lojabras.app.service.VendasService;

import br.lojabras.app.validation.VendasValidator;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AtualizarTodasVendasUseCase {
	
	private final VendasService service;

	private final VendasValidator validator;

	public VendasDTO execute(Long id, VendasDTO venda) {
		validator.validate(venda);
		VendasEntity entity = service.obterVendaPorId(id);
		service.atualizar(entity, venda);
		return entity.toDTO();

}
}