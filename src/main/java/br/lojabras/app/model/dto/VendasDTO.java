package br.lojabras.app.model.dto;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotBlank(message ="não foi declarado")
	private ClienteDTO cliente;
	
	@NotBlank(message ="não foi declarado")
	private List<EstoqueDTO> produto;
	
	@NotBlank(message ="não foi declarado")
	private Date data;
	
	@NotBlank(message ="não foi declarado")
	private String condicao;
	
	@NotBlank(message ="não foi declarado")
	private String frete;
	
	@NotNull(message="não foi declarado")
	@Min(value=1, message="valor mínimo deve ser 1")
	private Double valor;
	
	@NotBlank(message ="não foi declarado")
	private String status;
	
	@NotBlank(message ="não foi declarado")
	private String tipoEndereco;

	public VendasEntity toEntity() {
		return new VendasEntity(id, cliente.toEntity(), produto.stream().map(EstoqueDTO::toEntity).collect(toList()),
				data, condicao, frete, valor, status, tipoEndereco);
	}

}
