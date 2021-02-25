package br.lojabras.app.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lojabras.app.model.dto.BuscaBancoDTO;
import br.lojabras.app.usecase.BuscaBancoUseCase;
import lombok.AllArgsConstructor;

@RestController
public class BuscaBancoController {
	
	@Autowired
	private BuscaBancoUseCase buscaUseCase;
	
	@GetMapping("/buscaBanco/{banco}")
	public ResponseEntity<BuscaBancoDTO> obterBanco(@PathVariable("banco") String banco) {
		return ok(buscaUseCase.execute(banco));
	}
}