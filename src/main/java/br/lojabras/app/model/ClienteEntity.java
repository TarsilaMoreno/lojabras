package br.lojabras.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.lojabras.app.model.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "clientes")
public class ClienteEntity {

	public ClienteEntity() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String apelido;
	@ManyToOne
	private EnderecoEntity endereco;
	@ManyToOne
	private EnderecoEntity entrega;
	private Long telefone;
	private Long cpf;
	private Long cnpj;
	private String email;
	private Double limiteCredito;
	
	public ClienteDTO toDTO() {
		return new ClienteDTO(
				id, 
				nome, 
				apelido, 
				telefone, 
				cpf, 
				cnpj, 
				email, 
				limiteCredito);
	}
	

}
