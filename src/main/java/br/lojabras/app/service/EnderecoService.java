package br.lojabras.app.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.lojabras.app.model.EnderecoEntity;
import br.lojabras.app.model.dto.EnderecoDTO;
import br.lojabras.app.repository.EnderecoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoService {
	
	private final EnderecoRepository repository;
	
	public void inserir(EnderecoEntity endereco) {
		repository.save(endereco);
	}
	
	public List<EnderecoEntity> obterTodos() {
		return repository.findAll();
	}
	public EnderecoEntity obterEnderecoPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Endereco_de_id_" + id + "_nao_encontrado", 1));
	}
	public void atualizar(EnderecoEntity entity,EnderecoDTO endereco) {
		entity.merge(endereco);
		repository.save(entity);
	}
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
}