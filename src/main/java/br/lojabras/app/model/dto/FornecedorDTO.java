package br.lojabras.app.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.lojabras.app.model.FornecedorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FornecedorDTO implements Serializable {

	private static final long serialVersionUID = 7252653205145787460L;

	private Long id;

	@NotNull(message="não foi declarado")
	@Size(min = 14, max = 14 , message= "declare um número válido")
	private Long cnpj;
	
	@NotBlank(message ="não foi declarado")
	
	@NotBlank(message ="não foi declarado")
	private String razaoSocial;
	
	@NotBlank(message ="não foi declarado")
	private String nomeFantasia;
	
	@NotBlank(message ="não foi declarado")
	private String telefone;
	
	@NotBlank(message ="não foi declarado")
	private String email;
	
	@NotBlank(message ="não foi declarado")
	private String endereco;
	
	@NotBlank(message ="não foi declarado")
	private String contato;

	public FornecedorEntity toEntity() {
		return new FornecedorEntity(id , 
				cnpj , 
				razaoSocial , 
				nomeFantasia , 
				telefone , 
				email, 
				endereco, 
				contato);
		
	}

	public FornecedorDTO toDTO() {
		return null;
	}
}
