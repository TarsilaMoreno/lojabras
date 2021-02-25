package br.lojabras.app.service;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lojabras.app.model.dto.BuscaBancoDTO;
import br.lojabras.app.util.ResponseUtilHelper;

@Service
public class BuscaBancoService {

	private static final String BANCO_API = "banks/v1/%s";

	@Autowired
	private ResponseUtilHelper parseHelper;

	@Autowired
	private WebTarget targetBrasilApi;

	public BuscaBancoDTO obterBanco(String banco) {
		Response response = targetBrasilApi
				.path(format(BANCO_API, banco))
				.request(APPLICATION_JSON).get();

		return ofNullable(parseHelper.read(response, BuscaBancoDTO.class)).orElseThrow();

	}
}
