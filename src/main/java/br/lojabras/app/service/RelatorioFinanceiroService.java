package br.lojabras.app.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import br.lojabras.app.model.VendasEntity;
import br.lojabras.app.repository.VendasRepositoryService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RelatorioFinanceiroService {

	private final VendasRepositoryService repositoryService;

	public List<VendasEntity> geraRelatorioFinanceiro(String status,Double valor, String dataIni, String dataFim, Long cliente, Long produto)
			throws ParseException {
		return repositoryService.geraRelatorioFinanceiro(status,valor, dataIni, dataFim, cliente, produto);
	}
}
