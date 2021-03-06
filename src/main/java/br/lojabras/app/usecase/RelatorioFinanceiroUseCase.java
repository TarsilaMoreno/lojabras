package br.lojabras.app.usecase;

import static java.util.stream.Collectors.toList;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.VendasEntity;
import br.lojabras.app.model.dto.VendasDTO;
import br.lojabras.app.service.RelatorioFinanceiroService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RelatorioFinanceiroUseCase {
	
	public final RelatorioFinanceiroService service;
	
	public List<VendasDTO> execute(String status,Double valor, String dataIni, String dataFim, Long cliente, Long produto) throws ParseException {
		return service.geraRelatorioFinanceiro(status,valor, dataIni, dataFim, cliente, produto)
				.stream().map(VendasEntity::toDTO).collect(toList());
	}
}
