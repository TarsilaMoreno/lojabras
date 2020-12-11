package br.lojabras.app.validation;

import static java.util.Optional.ofNullable;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.EnderecoEntity;

import br.lojabras.app.model.dto.EnderecoDTO;
import br.lojabras.app.validation.exception.EnderecoNaoExisteException;


@Component
public class EnderecoValidator {

	public void validate(EnderecoDTO endereco) {

		if (ofNullable(endereco.getLogradouro()).orElseThrow(() -> new EnderecoNaoExisteException("logradouro_nao_foi_declarado"))
				.isBlank())
			throw new EnderecoNaoExisteException("logradouro_nao_foi_declarado");
		
		if (ofNullable(endereco.getNumero()).orElseThrow(() -> new EnderecoNaoExisteException("numero_nao_foi_declarado"))
				.isBlank())
			throw new EnderecoNaoExisteException("numero_nao_foi_declarado");
		
		if (ofNullable(endereco.getComplemento()).orElseThrow(() -> new EnderecoNaoExisteException("complemento_nao_foi_declarado"))
				.isBlank())
			throw new EnderecoNaoExisteException("complemento_nao_foi_declarado");
		
		if (ofNullable(endereco.getBairro()).orElseThrow(() -> new EnderecoNaoExisteException("bairro_nao_foi_declarado"))
				.isBlank())
			throw new EnderecoNaoExisteException("bairro_nao_foi_declarado");
		
		if (ofNullable(endereco.getCidade()).orElseThrow(() -> new EnderecoNaoExisteException("cidade_nao_foi_declarado"))
				.isBlank())
			throw new EnderecoNaoExisteException("cidade_nao_foi_declarado");
		
		if (ofNullable(endereco.getCep()).orElseThrow(() -> new EnderecoNaoExisteException("cep_nao_foi_declarado"))
				.isBlank())
			throw new EnderecoNaoExisteException("cep_nao_foi_declarado");
		
		if (ofNullable(endereco.getEstado()).orElseThrow(() -> new EnderecoNaoExisteException("estado_nao_foi_declarado"))
				.isBlank())
			throw new EnderecoNaoExisteException("estado_nao_foi_declarado");
	}

	public void validate(EnderecoEntity endereco) {
		this.validate(endereco.toDTO());
	}
}
