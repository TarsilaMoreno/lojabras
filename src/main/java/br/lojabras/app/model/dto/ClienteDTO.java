package br.lojabras.app.model.dto;

import java.io.Serializable;

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
	private String apelido;
	private Long telefone;
	private Long cpf;
	private Long cnpj;
	private String email;
	private Double limiteCredito;
	
	public ClienteEntity toEntity() {
		return new ClienteEntity();
//				id,
//				nome,
//				apelido
//				telefone,
//				cpf,
//				cnpj,
//				email,
//				limiteCredito);
		
	}
	
}
