package br.lojabras.app.model.dto;

import static java.lang.Long.parseLong;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	
	@NotBlank(message ="não foi declarado")
	private String nome;
	
	@NotBlank(message ="não foi declarado")
	private String apelido;
	
	
	@NotBlank(message ="não foi declarado")
	@Size(min = 10, max = 11, message= "declare um número válido")
	@Pattern(regexp="^[0-9]*$", message = "informe apenas números")
	private String telefone;
	
	@NotBlank(message="não foi declarado")
	@Size(min = 11, max = 11, message= "declare um número válido")
	@Pattern(regexp="^[0-9]*$", message = "informe apenas números")
	private String cpf;
	
	@NotBlank(message="não foi declarado")
	@Size(min = 14, max = 14 , message= "declare um número válido")
	@Pattern(regexp="^[0-9]*$",message = "informe apenas números")
	private String cnpj;
	
	@NotBlank(message ="não foi declarado")
	private String email;
	
	@NotNull(message="não foi declarado")
	@Min(value=1, message="valor mínimo deve ser 1")
	private Double limiteCredito;
	
	@Valid
	private EnderecoDTO endereco;
	@Valid
	private EnderecoDTO entrega;
	
	public ClienteEntity toEntity() {
		
		return new ClienteEntity(id, nome, apelido, Objects.isNull(endereco) ? null : endereco.toEntity(), Objects.isNull(entrega) ? null : entrega.toEntity(), parseLong(telefone), parseLong(cpf), parseLong(cnpj), email, limiteCredito);
	}

	public ClienteDTO toDTO() {

		return null;
	}
	
}
