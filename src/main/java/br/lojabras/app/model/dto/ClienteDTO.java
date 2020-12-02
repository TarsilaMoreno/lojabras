package br.lojabras.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO {
	
	private Long id;
	private String nome;
	private String apelido;
	private Long telefone;
	private Long cpf;
	private Long cnpj;
	private String email;
	private Double limiteCredito;
	
}
