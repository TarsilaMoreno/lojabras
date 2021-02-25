package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.FornecedorDTO;
import br.lojabras.app.service.FornecedorService;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class ObterOneFornecedorUseCase {
	
private final FornecedorService service;
	
	public FornecedorDTO execute(Long id) {
		return service.obterFornecedorPorId(id).toDTO();
	}

}




	
