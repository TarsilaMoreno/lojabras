package br.lojabras.app.service;

import static java.lang.String.format;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.lojabras.app.model.dto.EnderecoCepDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscaCepService {

	private static final String CEP_API = "https://viacep.com.br/ws/%s/json/unicode/";
	
	private final RestTemplate rest;

	public EnderecoCepDTO obterCep(String cep) {
		try {
			return rest.getForEntity(format(CEP_API, cep), EnderecoCepDTO.class).getBody();
		} catch (Exception e) {
			throw new EmptyResultDataAccessException(1);
		}
	}

	
}
