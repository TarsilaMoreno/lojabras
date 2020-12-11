package br.lojabras.app.model;

import static java.util.Optional.ofNullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.lojabras.app.model.dto.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "enderecos")
public class EnderecoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	@OneToOne
	@JoinColumn(name="id")
	private ClienteEntity cliente;

	public EnderecoDTO toDTO() {
		return new EnderecoDTO(id, logradouro, numero, complemento, bairro, cidade, estado, cep, null);
	}

//	public EnderecoEntity(Long id, String logradouro,String numero,
//	 String complemento, String bairro, String cidade, String estado, String cep, cliente.toEntity());
//}

	public EnderecoEntity() {
		super();
	}

	public void merge(EnderecoDTO enderecoDTO) {

		this.logradouro = ofNullable(enderecoDTO.getLogradouro()).orElse(logradouro);
		this.numero = ofNullable(enderecoDTO.getNumero()).orElse(numero);
		this.complemento = ofNullable(enderecoDTO.getComplemento()).orElse(complemento);
		this.bairro = ofNullable(enderecoDTO.getBairro()).orElse(bairro);
		this.cidade = ofNullable(enderecoDTO.getCidade()).orElse(cidade);
		this.estado = ofNullable(enderecoDTO.getLogradouro()).orElse(estado);
		this.cep = ofNullable(enderecoDTO.getCep()).orElse(cep);

	}

}