package br.lojabras.app.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.model.dto.EstoqueDTO;
import br.lojabras.app.usecase.AtualizarTodosEstoqueUseCase;
import br.lojabras.app.usecase.DeletarProdutoUseCase;
import br.lojabras.app.usecase.InserirProdutoEstoqueUseCase;
import br.lojabras.app.usecase.ObterOneEstoqueUseCase;
import br.lojabras.app.usecase.ObterTodosEstoqueUseCase;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/estoque")
@AllArgsConstructor
public class EstoqueRestController {

		// @PutMapping
		// @DeleteMapping
	
	private final ObterTodosEstoqueUseCase obterTodosUseCase;
	
	private final InserirProdutoEstoqueUseCase inserirUseCase;
	
	private final AtualizarTodosEstoqueUseCase atualizarUseCase;
	
	private final DeletarProdutoUseCase deletarUseCase;
	
	private final ObterOneEstoqueUseCase obterOneUseCase;
	
	@GetMapping
	public ResponseEntity<List<EstoqueDTO>> obterTodosEstoques() {
		return ok(obterTodosUseCase.execute());
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> obterOneEstoques() {
		return ok(obterOneUseCase.execute1());
	}
	
	@PostMapping
	public ResponseEntity<EstoqueDTO> inserir(@RequestBody EstoqueDTO produto) {
		return ok(inserirUseCase.execute(produto));
	}
	
//	@PutMapping
//	public ResponseEntity<EstoqueDTO> atualizar(@RequestBody EstoqueDTO produto) {
//		return ok(atualizarUseCase.execute(produto));
	
	
	@DeleteMapping
	public ResponseEntity<EstoqueDTO> deletar(@RequestBody EstoqueDTO produto) {
		return ok(deletarUseCase.execute(produto));
	}
}
	

