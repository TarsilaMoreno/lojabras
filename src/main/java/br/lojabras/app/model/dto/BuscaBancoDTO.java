package br.lojabras.app.model.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BuscaBancoDTO implements Serializable {

	
	private static final long serialVersionUID = -4497364172085731146L;
	
	public String name;
	public String code;
	public String fullName;
	

}
