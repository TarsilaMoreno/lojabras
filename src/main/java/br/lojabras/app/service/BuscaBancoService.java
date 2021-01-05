package br.lojabras.app.service;

import static java.lang.String.format;

import java.net.URISyntaxException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.lojabras.app.model.dto.BuscaBancoDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscaBancoService {

	private static final String BANCO_API = "https://brasilapi.com.br/api/banks/v1/%s";

	private final RestTemplate rest;
	
	public BuscaBancoDTO obterBanco(String banco) {
		try {
			return rest.getForEntity(format(BANCO_API, banco), BuscaBancoDTO.class).getBody();
		} catch (Exception e) {
			throw new EmptyResultDataAccessException(1);
		}
	}
}
