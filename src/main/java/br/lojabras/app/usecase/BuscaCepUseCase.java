package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.EnderecoCepDTO;
import br.lojabras.app.service.BuscaCepService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BuscaCepUseCase {
	
	 private final BuscaCepService service;
	 
	 public EnderecoCepDTO execute(String cep) {
		 return service.obterCep(cep);
	 }
	

}
