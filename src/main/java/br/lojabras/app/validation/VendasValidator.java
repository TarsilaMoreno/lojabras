package br.lojabras.app.validation;

import static java.util.Optional.ofNullable;

import org.springframework.stereotype.Component;


import br.lojabras.app.model.VendasEntity;
import br.lojabras.app.model.dto.VendasDTO;

import br.lojabras.app.validation.exception.VendaNaoExisteException;

@Component
public class VendasValidator {
	
	public void validate(VendasDTO venda) {
		if (ofNullable(venda.getCliente()).orElseThrow(() -> new VendaNaoExisteException("Cliente_nao_foi_declarado")).toString().isBlank())
			throw new VendaNaoExisteException("Cliente_nao_foi_declarado");
		
		if (ofNullable(venda.getData()).orElseThrow(() -> new VendaNaoExisteException("Data_nao_foi_declarada")).toString().isBlank())
			throw new VendaNaoExisteException("Data_nao_foi_declarada");
		
		if (ofNullable(venda.getCondicao()).orElseThrow(() -> new VendaNaoExisteException("Condicao_nao_foi_declarada")).toString().isBlank())
			throw new VendaNaoExisteException("Condicao_nao_foi_declarada");
		
		
		if (ofNullable(venda.getFrete()).orElseThrow(() -> new VendaNaoExisteException("Frete_nao_foi_declarado")).isBlank())
			throw new VendaNaoExisteException("Frete_nao_foi_declarado");
		
		
		if (ofNullable(venda.getValor()).orElseThrow(() -> new VendaNaoExisteException("Valor_nao_foi_declarado")).toString().length() <= 0)
			throw new VendaNaoExisteException("Valor_nao_foi_declarado");
		
		
		if (ofNullable(venda.getStatus()).orElseThrow(() -> new VendaNaoExisteException("Status_nao_foi_declarado")).toString().isBlank())
			throw new VendaNaoExisteException("Status_nao_foi_declarado");
		
		
		if (ofNullable(venda.getProduto()).orElseThrow(() -> new VendaNaoExisteException("Produto_nao_foi_declarado")).toString().isBlank())
			throw new VendaNaoExisteException("Produto_nao_foi_declarado");
		
		if (ofNullable(venda.getTipoEndereco()).orElseThrow(() -> new VendaNaoExisteException("Tipo_Endereco_nao_foi_declarado")).toString().isBlank())
			throw new VendaNaoExisteException("Tipo_Endereco_nao_foi_declarado");
	}
	public void validate(VendasEntity venda) {
		 this.validate(venda.toDTO());
	 }
}