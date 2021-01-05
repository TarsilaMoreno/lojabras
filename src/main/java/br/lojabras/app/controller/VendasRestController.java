package br.lojabras.app.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.lojabras.app.model.dto.VendasDTO;
import br.lojabras.app.usecase.AtualizarTodasVendasUseCase;
import br.lojabras.app.usecase.DeletarVendaUseCase;
import br.lojabras.app.usecase.InserirVendaEstoqueUseCase;
import br.lojabras.app.usecase.ObterOneVendaUseCase;
import br.lojabras.app.usecase.ObterTodasVendasUseCase;
import br.lojabras.app.usecase.RelatorioFinanceiroUseCase;
import br.lojabras.app.usecase.RelatorioVendasUseCase;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/venda")
@AllArgsConstructor
public class VendasRestController {

	private final InserirVendaEstoqueUseCase inserirUseCase;

	private final ObterTodasVendasUseCase obterTodasUseCase;

	private final ObterOneVendaUseCase obterOneUseCase;

	private final AtualizarTodasVendasUseCase atualizarUseCase;

	private final DeletarVendaUseCase deletarUseCase;

	private final RelatorioFinanceiroUseCase relatorioFinanceiroUseCase;
	
	private final RelatorioVendasUseCase relatorioVendasUseCase;

	@PostMapping
	public ResponseEntity<VendasDTO> inserir(@RequestBody VendasDTO venda) {
		return ok(inserirUseCase.execute(venda));
	}

	@GetMapping
	public ResponseEntity<List<VendasDTO>> obterTodasVendas() {
		return ok(obterTodasUseCase.execute());
	}

	@GetMapping("/{id}")
	public ResponseEntity<VendasDTO> obterOneEstoques(@PathVariable("id") Long id) {
		return ok(obterOneUseCase.execute(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<VendasDTO> atualizar(@PathVariable("id") Long id, @RequestBody VendasDTO venda) {
		return ok(atualizarUseCase.execute(id, venda));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		deletarUseCase.execute(id);
		return noContent().build();
	}

	@GetMapping("/relatorioVendas")
	public ResponseEntity<List<VendasDTO>> gerarRelatorio(@RequestParam(required = false) String dataIni,
			@RequestParam(required = false) String dataFim, @RequestParam(required = false) String status,
			@RequestParam(required = false) String condicao) throws ParseException {
		
		return ok(relatorioVendasUseCase.execute(status, condicao, dataIni, dataFim));
	}
	
	@GetMapping("/relatorioFinanceiro")
	public ResponseEntity<List<VendasDTO>> gerarRelatorioFinanceiro(@RequestParam(required = false) String dataIni,
			@RequestParam(required = false) String dataFim, @RequestParam(required = false) String status, @RequestParam(required = false) Long cliente,
			@RequestParam(required = false) Long produto, @RequestParam(required = false) Double valor) throws ParseException {
		
		return ok(relatorioFinanceiroUseCase.execute(status,valor, dataIni, dataFim, cliente, produto));

	}
}