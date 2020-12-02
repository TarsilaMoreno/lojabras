package br.lojabras.app.model.dto;

import java.io.Serializable;

import br.lojabras.app.model.EstoqueEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EstoqueDTO implements Serializable {
	
	private static final long serialVersionUID = 7252653205145787460L;
	
	private Long id;
	private String tipo;
	private Double largura;
	private String cor;
	private Double totalKg;
	private Double totalUn;
	private Double valorInd;
	
	public EstoqueEntity toEntity() {
		return new EstoqueEntity(id, tipo, largura, cor, totalKg, totalUn, valorInd);
	}

}
