package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.FornecedorEntity;
import br.lojabras.app.model.dto.FornecedorDTO;
import br.lojabras.app.service.FornecedorService;
import br.lojabras.app.validation.FornecedorValidator;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AtualizarFornecedorUseCase {
	
	private final FornecedorService service;
	
	
	private final FornecedorValidator validator;

	public FornecedorDTO execute(Long id,FornecedorDTO fornecedor) {
		validator.validate(fornecedor);
		FornecedorEntity entity = service.obterFornecedorPorId(id);
		service.atualizar(entity,fornecedor);
		return entity.toDTO();
	}
		
	

}
