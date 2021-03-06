package br.lojabras.app.usecase;

import static java.util.stream.Collectors.toList;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Component;

import br.lojabras.app.model.VendasEntity;
import br.lojabras.app.model.dto.VendasDTO;
import br.lojabras.app.service.RelatorioVendasService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class RelatorioVendasUseCase {
	
public final RelatorioVendasService service;
	
	public List<VendasDTO> execute(String status,String condicao, String dataIni, String dataFim) throws ParseException {
		return service.geraRelatorio(status,condicao, dataIni, dataFim).stream().map(VendasEntity::toDTO).collect(toList());
	}

}
