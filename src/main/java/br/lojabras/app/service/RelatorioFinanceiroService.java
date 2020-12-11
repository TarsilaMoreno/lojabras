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
	
	public List<VendasEntity> geraRelatorio(String status,String condicao, String dataIni, String dataFim) throws ParseException {
		return repositoryService.geraRelatorio(status,condicao, dataIni, dataFim);
	}
	
}