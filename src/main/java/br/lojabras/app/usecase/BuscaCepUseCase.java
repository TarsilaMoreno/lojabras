package br.lojabras.app.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.EnderecoCepDTO;
import br.lojabras.app.service.BuscaCepService;

@Component
public class BuscaCepUseCase {

	@Autowired
	private BuscaCepService service;

	public EnderecoCepDTO execute(String cep) {
		return service.obterCep(cep);
	}

}
