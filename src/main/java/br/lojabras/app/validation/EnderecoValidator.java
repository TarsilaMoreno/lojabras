package br.lojabras.app.validation;

import static java.util.Optional.ofNullable;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.EnderecoEntity;

import br.lojabras.app.model.dto.EnderecoDTO;
import br.lojabras.app.validation.exception.EnderecoNaoExisteException;


@Component
public class EnderecoValidator {

	public void validate(EnderecoDTO endereco) {

		
	}

	public void validate(EnderecoEntity endereco) {
		this.validate(endereco.toDTO());
	}
}
