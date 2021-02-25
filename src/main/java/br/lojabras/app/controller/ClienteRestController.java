package br.lojabras.app.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.usecase.AtualizarClienteUseCase;
import br.lojabras.app.usecase.DeletarClienteUseCase;
import br.lojabras.app.usecase.InserirClienteUseCase;
import br.lojabras.app.usecase.ObterOneClienteUseCase;
import br.lojabras.app.usecase.ObterTodosClientesUseCase;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteRestController {


	private final ObterTodosClientesUseCase obterTodosUseCase;

	private final InserirClienteUseCase inserirUseCase;
	
	private final ObterOneClienteUseCase obterOneUseCase;
	
	private AtualizarClienteUseCase atualizarUseCase;
	
	private DeletarClienteUseCase deletarUseCase;

	@PostMapping
	public ResponseEntity<ClienteDTO> inserir(@Valid @RequestBody ClienteDTO cliente) {
		return ok(inserirUseCase.execute(cliente));
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> obterTodosClientes() {
		return ok(obterTodosUseCase.execute());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> obterOneCliente(@PathVariable("id") Long id) {
		return ok(obterOneUseCase.execute(id));

	}
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable("id") Long id,@RequestBody ClienteDTO cliente) {
		return ok(atualizarUseCase.execute(id,cliente));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		deletarUseCase.execute(id);
		return noContent().build();
	}
}