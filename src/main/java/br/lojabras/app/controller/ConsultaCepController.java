package br.lojabras.app.controller;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.lojabras.app.model.dto.EnderecoCepDTO;
import br.lojabras.app.usecase.BuscaCepUseCase;

@RestController
public class ConsultaCepController {

	@Autowired
	private BuscaCepUseCase buscaUseCase;

	@GetMapping("/buscaCep/{cep}")
	public ResponseEntity<EnderecoCepDTO> obterCep(@PathVariable String cep) {
		return ok(buscaUseCase.execute(cep));

	}
}