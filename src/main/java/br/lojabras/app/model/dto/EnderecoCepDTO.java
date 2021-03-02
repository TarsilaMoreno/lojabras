package br.lojabras.app.model.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoCepDTO implements Serializable {

	private static final long serialVersionUID = -6743445728024233549L;

	public String cep;
	public String logradouro;
	public String complemento;
	public String bairro;
	public String localidade;
	public String uf;

}
