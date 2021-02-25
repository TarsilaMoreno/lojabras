package br.lojabras.app.validation;

import static java.util.Optional.ofNullable;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.EstoqueEntity;
import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.validation.exception.ProdutoNaoExisteException;

@Component
public class EstoqueProdutoValidator {

	public void validate(EstoqueDTO estoque) {

		/*if (ofNullable(estoque.getTipo()).orElseThrow(() -> new ProdutoNaoExisteException("tipo_nao_foi_declarado"))
				.isBlank())
			throw new ProdutoNaoExisteException("tipo_nao_foi_declarado"); */

		/*if (ofNullable(estoque.getCor()).orElseThrow(() -> new ProdutoNaoExisteException("cor_nao_foi_declarado"))
				.isBlank())
			throw new ProdutoNaoExisteException("cor_nao_foi_declarado"); */

		/*if (ofNullable(estoque.getTotalUn())
				.orElseThrow(() -> new ProdutoNaoExisteException("total_un_nao_foi_declarado_ou_e_negativo")) <= 0)
			throw new ProdutoNaoExisteException("total_un_nao_foi_declarado_ou_e_negativo"); */

		/*if (ofNullable(estoque.getTotalKg())
				.orElseThrow(() -> new ProdutoNaoExisteException("total_kg_nao_foi_declarado_ou_e_negativo")) <= 0)
			throw new ProdutoNaoExisteException("total_kg_nao_foi_declarado_ou_e_negativo");

		if (ofNullable(estoque.getLargura()).orElseThrow(
				() -> new ProdutoNaoExisteException("largura_nao_foi_declarado_ou_nao_e_maior_que_zero")) < 0)
			throw new ProdutoNaoExisteException("largura_nao_foi_declarado_ou_nao_e_maior_que_zero");

		if (ofNullable(estoque.getValorInd()).orElseThrow(
				() -> new ProdutoNaoExisteException("valor_nao_foi_declarado_ou_nao_e_maior_que_zero")) < 0)
			throw new ProdutoNaoExisteException("valor_nao_foi_declarado_ou_nao_e_maior_que_zero"); */
	}

	public void validate(EstoqueEntity estoque) {
		this.validate(estoque.toDTO());
	}

}
