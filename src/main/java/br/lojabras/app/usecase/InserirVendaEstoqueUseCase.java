package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;


import br.lojabras.app.model.dto.VendasDTO;

import br.lojabras.app.service.VendasService;

import br.lojabras.app.validation.VendasValidator;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InserirVendaEstoqueUseCase {

	private final VendasService service;
	private final VendasValidator validator;

	public VendasDTO execute(VendasDTO venda) {
		validator.validate(venda);
		service.inserir(venda.toEntity());
		return venda;

	}
}