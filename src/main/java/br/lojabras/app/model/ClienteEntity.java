package br.lojabras.app.model;

import static java.util.Optional.ofNullable;

import javax.persistence.CascadeType;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String apelido;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private EnderecoEntity endereco;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private EnderecoEntity entrega;
	private Long telefone;
	private Long cpf;
	private Long cnpj;
	private String email;
	private Double limiteCredito;

	public ClienteDTO toDTO() {
		return new ClienteDTO(id, nome, apelido, telefone.toString(), cpf.toString(), cnpj.toString(), email, limiteCredito, endereco.toDTO(),
				entrega.toDTO());
	}

	public ClienteEntity(Long id, String nome, String apelido, Long telefone, Long cpf, Long cnpj, String email,
			Double limiteCredito) {
		super();
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.email = email;
		this.limiteCredito = limiteCredito;
	}

	public ClienteEntity() {
		super();
	}

	public void merge(ClienteDTO clienteDTO) {
		this.nome = ofNullable(clienteDTO.getNome()).orElse(nome);
		this.apelido = ofNullable(clienteDTO.getApelido()).orElse(apelido);
		this.cnpj = Long.valueOf(ofNullable(clienteDTO.getCnpj()).orElse(cnpj.toString()));
		this.cpf = Long.valueOf(ofNullable(clienteDTO.getCpf()).orElse(cpf.toString()));
		this.email = ofNullable(clienteDTO.getEmail()).orElse(email);
		this.limiteCredito = ofNullable(clienteDTO.getLimiteCredito()).orElse(limiteCredito);
	}
	
}
