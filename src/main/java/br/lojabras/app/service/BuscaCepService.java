package br.lojabras.app.service;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lojabras.app.model.dto.EnderecoCepDTO;
import br.lojabras.app.util.ResponseUtilHelper;


@Service
public class BuscaCepService {
	

	private static final String CEP_API = "json/unicode";

	@Autowired
	private ResponseUtilHelper parseHelper;

	@Autowired
	private WebTarget target;

	public EnderecoCepDTO obterCep(String cep) {
		Response response = target.path(cep).path(CEP_API)
				.request(APPLICATION_JSON)
				.get();

		return ofNullable(parseHelper.read(response, EnderecoCepDTO.class)).orElseThrow();

	}

}
