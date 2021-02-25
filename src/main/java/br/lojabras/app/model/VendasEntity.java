package br.lojabras.app.model;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.lojabras.app.model.dto.VendasDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "vendas")
public class VendasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ClienteEntity cliente;
	@ManyToMany
	private List<EstoqueEntity> produto;
	private Date data;
	private String condicao;
	private String frete;
	private Double valor;
	private String status;

	@Column(length = 1)
	private String tipoEndereco;

	public VendasDTO toDTO() {
		return new VendasDTO(id, cliente.toDTO(), produto.stream().map(EstoqueEntity::toDTO).collect(toList()), data,
				condicao, frete, valor, status, tipoEndereco);

	}

	public VendasEntity(Long id, Date data, String condicao, String frete, Double valor, String status, String tipoEndereco) {
		super();
		this.id = id;
		this.data = data;
		this.condicao = condicao;
		this.frete = frete;
		this.valor = valor;
		this.status = status;
		this.tipoEndereco = tipoEndereco;

	}

	public VendasEntity() {
		super();
	}

	public void merge(VendasDTO vendasDTO) {
		this.data = ofNullable(vendasDTO.getData()).orElse(data);
		this.condicao = ofNullable(vendasDTO.getCondicao()).orElse(condicao);
		this.frete = ofNullable(vendasDTO.getFrete()).orElse(frete);
		this.valor = ofNullable(vendasDTO.getValor()).orElse(valor);
		this.status = ofNullable(vendasDTO.getStatus()).orElse(status);
		this.tipoEndereco = ofNullable(vendasDTO.getTipoEndereco()).orElse(tipoEndereco);

	}

}
