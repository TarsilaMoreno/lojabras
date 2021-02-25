package br.lojabras.app.model.dto;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.lojabras.app.model.ClienteEntity;
import br.lojabras.app.model.EstoqueEntity;
import br.lojabras.app.model.VendasEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VendasDTO implements Serializable {

	private static final long serialVersionUID = 4611852271759544990L;

	private Long id;
	private ClienteDTO cliente;
	private List<EstoqueDTO> produto;
	private Date data;
	private String condicao;
	private String frete;
	private Double valor;
	private String status;
	private String tipoEndereco;

	public VendasEntity toEntity() {
		return new VendasEntity(id, cliente.toEntity(), produto.stream().map(EstoqueDTO::toEntity).collect(toList()),
				data, condicao, frete, valor, status, tipoEndereco);
	}

}
