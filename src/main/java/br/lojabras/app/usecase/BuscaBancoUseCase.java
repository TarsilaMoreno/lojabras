package br.lojabras.app.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.BuscaBancoDTO;
import br.lojabras.app.service.BuscaBancoService;
import lombok.AllArgsConstructor;

@Component
public class BuscaBancoUseCase {
	
	@Autowired
	private BuscaBancoService service;
	 
	 public BuscaBancoDTO execute(String banco) {
		 return service.obterBanco(banco);
	 }
	

}
