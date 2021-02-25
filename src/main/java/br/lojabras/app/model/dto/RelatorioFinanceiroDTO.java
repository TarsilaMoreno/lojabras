package br.lojabras.app.model.dto;

import java.io.Serializable;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RelatorioFinanceiroDTO implements Serializable {
	
	private static final long serialVersionUID = -3694423711814439020L;

	private Long id;
	private String periodo;
	private Double valor;
	private String status;
	private ClienteDTO cliente;
	private FornecedorDTO fornecedor;
	
	
	
}
