package br.lojabras.app;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.validateMockitoUsage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.lojabras.app.model.ClienteEntity;
import br.lojabras.app.model.dto.ClienteDTO;
import br.lojabras.app.model.dto.EnderecoDTO;
import br.lojabras.app.service.ClienteService;
import br.lojabras.app.usecase.InserirClienteUseCase;
import br.lojabras.app.validation.ClienteCadastroValidator;

@RunWith(MockitoJUnitRunner.class)
public class InserirClienteUseCaseTest {
	
	 @InjectMocks
	 InserirClienteUseCase inserirClienteUseCase;
	 @InjectMocks
	 ClienteCadastroValidator clienteCadastroValidator;
	 
	 
	 @Mock
	 ClienteService service;
	 @Mock
	 ClienteCadastroValidator validator;
	 
	        
	 @Test
	 public void testarValidacao(){
		 
		 
		 EnderecoDTO endereco = new EnderecoDTO(1L, "Rua", "20", "0", "Vila", "Sao", "SP", "02312000");
		 EnderecoDTO entrega = new EnderecoDTO(1L, "Rua", "20", "0", "Vila", "Sao", "SP", "02312000");
		 
		 ClienteDTO cadastro = new ClienteDTO(1L,"tarsila" , "tata", 1199995555L, 33522288858L, 21254251000120L, "tarsila@tarsila.com", 10000.00 , endereco, entrega);
		 
		 inserirClienteUseCase.execute(cadastro);
		 ClienteEntity cliente = service.obterClientePorId(1L);
		 
		 assertEquals(cadastro.getId(), 2L);
		 assertEquals(cadastro.getApelido(), cliente.getApelido());
		 assertEquals(cadastro.getEmail(), cliente.getEmail());
	 }
	 
//	 private String nome(){
//		 return "Ola mundo";
//		 
//	 }
//	 
//	 public long soma (long a, long b){
//		 return a + b;
//	 }
	 
	 
	 
}
