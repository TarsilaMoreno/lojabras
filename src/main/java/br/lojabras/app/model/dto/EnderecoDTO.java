package br.lojabras.app.model.dto;

import java.io.Serializable;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

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
	
	@NotBlank(message="nao foi declarado")
	private String logradouro;
	
	@NotBlank(message="nao foi declarado")
	private String numero;
	
	@NotBlank(message="nao foi declarado")
	private String complemento;
	
	@NotBlank(message="nao foi declarado")
	private String bairro;
	
	@NotBlank(message="nao foi declarado")
	private String cidade;
	
	@NotBlank(message="nao foi declarado")
	private String estado;
	
	@NotBlank(message="nao foi declarado")
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
