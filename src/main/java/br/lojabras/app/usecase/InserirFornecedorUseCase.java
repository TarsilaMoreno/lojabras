package br.lojabras.app.usecase;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.dto.FornecedorDTO;
import br.lojabras.app.service.FornecedorService;
import br.lojabras.app.validation.FornecedorValidator;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InserirFornecedorUseCase {
	
	private final FornecedorService service;
	
	private final FornecedorValidator validator;
	
	public FornecedorDTO execute(FornecedorDTO cadastro) {
		validator.validate(cadastro);
		service.inserir(cadastro.toEntity());
		return cadastro;
	}
	
	
}
