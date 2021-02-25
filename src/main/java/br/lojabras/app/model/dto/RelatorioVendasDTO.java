package br.lojabras.app.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RelatorioVendasDTO implements Serializable{
	
	private static final long serialVersionUID = 7501390818874231651L;
	
	private Long id;
	private String periodo;
	private Double valor;
	private String status;
	private ClienteDTO cliente;
	private EstoqueDTO produto;
	
	
}

