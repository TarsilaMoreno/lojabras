package br.lojabras.app.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.usecase.ObterTodosClientesUseCase;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteRestController {
	
	// @PostMapping
	// @PatchMapping
	// @DeleteMapping
	
	private final ObterTodosClientesUseCase obterTodosUseCase;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> obterTodosClientes() {
		return ok(obterTodosUseCase.execute());
	}
	
}
