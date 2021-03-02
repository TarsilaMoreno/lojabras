package br.lojabras.app.validation;

import static java.util.Optional.ofNullable;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.FornecedorEntity;
import br.lojabras.app.model.dto.FornecedorDTO;
import br.lojabras.app.validation.exception.ClienteNaoExisteException;
import br.lojabras.app.validation.exception.FornecedorNaoExisteException;


@Component
public class FornecedorValidator {

	public void validate(FornecedorDTO cadastro) {
		
		/*if (ofNullable(cadastro.getCnpj()).orElseThrow(() -> new FornecedorNaoExisteException("cnpj_nao_foi_declarado")).toString().length() != 14)
			throw new ClienteNaoExisteException("cnpj_nao_foi_declarado");
		
		if (ofNullable(cadastro.getRazaoSocial()).orElseThrow(() -> new FornecedorNaoExisteException("razaoSocial_nao_foi_declarada")).isBlank())
			throw new ClienteNaoExisteException("razaoSocial_nao_foi_declarada");
		
		if (ofNullable(cadastro.getNomeFantasia()).orElseThrow(() -> new FornecedorNaoExisteException("nomeFantasia_nao_foi_declarado")).isBlank())
			throw new ClienteNaoExisteException("nomeFantasia_nao_foi_declarado");
		
		if (ofNullable(cadastro.getEndereco()).orElseThrow(() -> new FornecedorNaoExisteException("endereco_nao_foi_declarado")).isBlank())
			throw new ClienteNaoExisteException("endereco_nao_foi_declarado");
		
		if (ofNullable(cadastro.getTelefone()).orElseThrow(() -> new FornecedorNaoExisteException("telefone_nao_foi_declarado")).isBlank())
			throw new ClienteNaoExisteException("telefone_nao_foi_declarado");
		
		if (ofNullable(cadastro.getEmail()).orElseThrow(() -> new FornecedorNaoExisteException("email_nao_foi_declarado")).isBlank())
			throw new ClienteNaoExisteException("email_nao_foi_declarado");
		
		if (ofNullable(cadastro.getContato()).orElseThrow(() -> new FornecedorNaoExisteException("contato_nao_foi_declarado")).isBlank())
			throw new ClienteNaoExisteException("contato_nao_foi_declarado");	*/
	}
 public void validate(FornecedorEntity fornecedor) {
	 this.validate(fornecedor.toDTO());
 }
 
}
