package br.lojabras.app.model.dto;

import java.io.Serializable;
import java.util.Optional;


import br.lojabras.app.model.EnderecoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnderecoDTO implements Serializable {


	private static final long serialVersionUID = -4141291444898619665L;
	
	private Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	private ClienteDTO cliente;

	public EnderecoEntity toEntity() {
		return new EnderecoEntity(
				id, 
				logradouro, 
				numero, 
				complemento, 
				bairro, 
				cidade, 
				estado, 
				cep, null);
	}
	
}
