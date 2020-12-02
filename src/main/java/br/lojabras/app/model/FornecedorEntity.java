package br.lojabras.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name="fornecedor")
public class FornecedorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String telefone;
	private String email;
	private String endereco;
	private String contato;
	
	 @OneToOne
	 private EstoqueEntity estoque;
	
	

}
