package br.lojabras.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.lojabras.app.model.dto.EstoqueDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="estoque")
public class EstoqueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipo;
	private Double largura;
	private String cor;
	private Double totalKg;
	private Double totalUn;
	private Double valorInd;
	
	
	public EstoqueDTO toDTO() {
		return new EstoqueDTO(
				id, 
				tipo, 
				largura, 
				cor, 
				totalKg, 
				totalUn, 
				valorInd);
	}

	

	public EstoqueEntity(Long id, String tipo, Double largura, String cor, Double totalKg, Double totalUn,
			Double valorInd) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.largura = largura;
		this.cor = cor;
		this.totalKg = totalKg;
		this.totalUn = totalUn;
		this.valorInd = valorInd;
	}



	public EstoqueEntity() {
		super();
	}

}
