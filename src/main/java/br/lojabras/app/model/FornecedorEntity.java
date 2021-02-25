package br.lojabras.app.model;

import static java.util.Optional.ofNullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.model.dto.FornecedorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "fornecedor")
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

	public FornecedorDTO toDTO() {
		return new FornecedorDTO(
				id, 
				cnpj, 
				razaoSocial, 
				nomeFantasia, 
				telefone, 
				email, 
				endereco, 
				contato);
	}
	
	public FornecedorEntity (Long id, Long cnpj, String razaoSocial, String nomeFantasia, String telefone,
	String email, String endereco, String contato) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.contato = contato;
		
	}
	public FornecedorEntity() {
		super();
	}
		
	public void merge(FornecedorDTO fornecedorDTO) {
		
		this.cnpj = ofNullable(fornecedorDTO.getCnpj()).orElse(cnpj);
		this.razaoSocial = ofNullable(fornecedorDTO.getRazaoSocial()).orElse(razaoSocial);
		this.nomeFantasia = ofNullable(fornecedorDTO.getNomeFantasia()).orElse(nomeFantasia);
		this.telefone = ofNullable(fornecedorDTO.getTelefone()).orElse(telefone);
		this.email = ofNullable(fornecedorDTO.getEmail()).orElse(email);
		this.endereco = ofNullable(fornecedorDTO.getEndereco()).orElse(endereco);
		this.contato = ofNullable(fornecedorDTO.getContato()).orElse(contato);
		
	}
}
