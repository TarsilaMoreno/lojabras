package br.lojabras.app.validation;

import static java.util.Optional.ofNullable;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.ClienteEntity;
import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.validation.exception.ClienteNaoExisteException;


@Component
public class ClienteCadastroValidator {
	
	public void validate(ClienteDTO cliente) {
		
		if (ofNullable(cliente.getNome()).orElseThrow(() -> new ClienteNaoExisteException("nome_nao_foi_declarado")).isBlank())
			throw new ClienteNaoExisteException("nome_nao_foi_declarado");
		
		if (ofNullable(cliente.getApelido()).orElseThrow(() -> new ClienteNaoExisteException("apelido_nao_foi_declarado")).isBlank())
			throw new ClienteNaoExisteException("apelido_nao_foi_declarado");
		
		if (ofNullable(cliente.getTelefone()).orElseThrow(() -> new ClienteNaoExisteException("telefone_nao_foi_declarado")).toString().isBlank())
			throw new ClienteNaoExisteException("telefone_nao_foi_declarado");
		
		if (ofNullable(cliente.getCpf()).orElseThrow(() -> new ClienteNaoExisteException("cpf_nao_foi_declarado")).toString().length() != 11)
			throw new ClienteNaoExisteException("cpf_nao_foi_declarado");
		
		if (ofNullable(cliente.getCnpj()).orElseThrow(() -> new ClienteNaoExisteException("cnpj_nao_foi_declarado")).toString().length() != 14)
			
			throw new ClienteNaoExisteException("cnpj_nao_foi_declarado");
		
		if (ofNullable(cliente.getEmail()).orElseThrow(() -> new ClienteNaoExisteException("email_nao_foi_declarado")).isBlank())
			throw new ClienteNaoExisteException("email_nao_foi_declarado");
		
		if (ofNullable(cliente.getLimiteCredito()).orElseThrow(() -> new ClienteNaoExisteException("limiteCredito_nao_foi_declarado")) < 0)
			throw new ClienteNaoExisteException("limiteCredito_nao_foi_declarado");
	}

	public void validate(ClienteEntity cliente) {
		this.validate(cliente.toDTO());
	}

}
