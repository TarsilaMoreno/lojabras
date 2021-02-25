package br.lojabras.app.usecase;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Component;


import br.lojabras.app.model.VendasEntity;

import br.lojabras.app.model.dto.VendasDTO;

import br.lojabras.app.service.VendasService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ObterTodasVendasUseCase {

	private final VendasService service;

	public List<VendasDTO> execute() {
		return service.obterTodas().stream().map(VendasEntity::toDTO).collect(toList());

	}
}