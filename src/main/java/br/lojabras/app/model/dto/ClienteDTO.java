package br.lojabras.app.model.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import br.lojabras.app.model.ClienteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 7252653205145787460L;
	
	private Long id;
	private String nome;
	@NotBlank(message ="não foi declarado")
	private String apelido;
	private Long telefone;
	private Long cpf;
	private Long cnpj;
	private String email;
	private Double limiteCredito;
	
	@Valid
	private EnderecoDTO endereco;
	@Valid
	private EnderecoDTO entrega;
	
	public ClienteEntity toEntity() {
		System.out.println(endereco);
		System.out.println(entrega);
		return new ClienteEntity(id, nome, apelido, Objects.isNull(endereco) ? null : endereco.toEntity(), Objects.isNull(entrega) ? null : entrega.toEntity(), telefone, cpf, cnpj, email, limiteCredito);
	}

	public ClienteDTO toDTO() {

		return null;
	}
	
}
