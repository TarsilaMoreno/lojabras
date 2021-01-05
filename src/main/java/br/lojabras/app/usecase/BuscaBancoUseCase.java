package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.BuscaBancoDTO;
import br.lojabras.app.service.BuscaBancoService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BuscaBancoUseCase {
	
	private final BuscaBancoService service;
	 
	 public BuscaBancoDTO execute(String banco) {
		 return service.obterBanco(banco);
	 }
	

}
