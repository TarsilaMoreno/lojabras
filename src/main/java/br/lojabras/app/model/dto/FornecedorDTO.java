package br.lojabras.app.model.dto;

import java.io.Serializable;

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

	private Long cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String telefone;
	private String email;
	private String endereco;
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
