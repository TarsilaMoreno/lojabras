package br.lojabras.app.model.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotBlank(message="não foi declarado")
	private String tipo;
	
	@NotNull(message="não foi declarado")
	@Min(value=1, message="valor mínimo deve ser 1")
	private Double largura;
	
	@NotBlank(message="não foi declarado")
	private String cor;
	
	@NotNull(message="não foi declarado")
	@Min(value=1, message="valor mínimo deve ser 1")
	private Double totalKg;
	
	@NotNull(message="não foi declarado")
	@Min(value=1, message="valor mínimo deve ser 1")
	private Double totalUn;
	
	@NotNull(message="não foi declarado")
	@Min(value=1, message="valor mínimo deve ser 1")
	private Double valorInd;
	
	public EstoqueEntity toEntity() {
		return new EstoqueEntity(
				id, 
				tipo, 
				largura, 
				cor, 
				totalKg, 
				totalUn, 
				valorInd);
	}

}
