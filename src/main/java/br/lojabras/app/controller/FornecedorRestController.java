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
import br.lojabras.app.model.dto.FornecedorDTO;
import br.lojabras.app.usecase.AtualizarFornecedorUseCase;
import br.lojabras.app.usecase.DeletarFornecedorUseCase;
import br.lojabras.app.usecase.InserirFornecedorUseCase;
import br.lojabras.app.usecase.ObterOneFornecedorUseCase;
import br.lojabras.app.usecase.ObterTodosFornecedorUseCase;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/fornecedor")
@AllArgsConstructor
public class FornecedorRestController {

	private final InserirFornecedorUseCase inserirUseCase;
	
	private final ObterTodosFornecedorUseCase obterTodosUseCase;
	
	private final ObterOneFornecedorUseCase obterOneUseCase;
	
	private final AtualizarFornecedorUseCase atualizarUseCase;
	
	private final DeletarFornecedorUseCase deletarUseCase;
	
	@PostMapping
	public ResponseEntity<FornecedorDTO> inserir(@RequestBody FornecedorDTO cadastro) {
		return ok(inserirUseCase.execute(cadastro));
	}
	@GetMapping
	public ResponseEntity<List<FornecedorDTO>> obterTodosFornecedor() {
		return ok(obterTodosUseCase.execute());
	}
	@GetMapping("/{id}")
	public ResponseEntity<FornecedorDTO> obterOneFornecedor(@PathVariable("id") Long id) {
		return ok(obterOneUseCase.execute(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<FornecedorDTO> atualizar(@PathVariable("id") Long id,@RequestBody FornecedorDTO fornecedor) {
		return ok(atualizarUseCase.execute(id,fornecedor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		deletarUseCase.execute(id);
		return noContent().build(); 
	}
}