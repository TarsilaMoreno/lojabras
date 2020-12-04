package br.lojabras.app.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	
	private final ObterTodosEstoqueUseCase obterTodosUseCase;
	
	private final InserirProdutoEstoqueUseCase inserirUseCase;
	
	private final AtualizarTodosEstoqueUseCase atualizarUseCase;
	
	private final DeletarProdutoUseCase deletarUseCase;
	
	private final ObterOneEstoqueUseCase obterOneUseCase;
	
	@GetMapping
	public ResponseEntity<List<EstoqueDTO>> obterTodosEstoques() {
		return ok(obterTodosUseCase.execute());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstoqueDTO> obterOneEstoques(@PathVariable("id") Long id) {
		return ok(obterOneUseCase.execute(id));
	}
	
	@PostMapping
	public ResponseEntity<EstoqueDTO> inserir(@RequestBody EstoqueDTO produto) {
		return ok(inserirUseCase.execute(produto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EstoqueDTO> atualizar(@PathVariable("id") Long id,@RequestBody EstoqueDTO produto) {
		return ok(atualizarUseCase.execute(id,produto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		deletarUseCase.execute(id);
		return noContent().build(); // 204 status
	}
}
	

