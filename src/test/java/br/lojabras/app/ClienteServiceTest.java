package br.lojabras.app;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import br.lojabras.app.model.ClienteEntity;
//import br.lojabras.app.response.BaseResponse;
//import br.lojabras.app.service.ClienteService;
//import br.lojabras.app.usecase.InserirClienteUseCase;
//import br.lojabras.app.validation.ClienteCadastroValidator;
//
//@ActiveProfiles("test")
//@SpringBootTest
//public class ClienteServiceTest {
//
//	@Autowired
//	private ClienteService service;
//
//	@Test
//	public void inserirCliente2() {
//		ClienteEntity cliente = new ClienteEntity();
//
//		cliente.setNome("Tarsila");
//		cliente.setApelido("tata");
//		cliente.setCpf(1L);
//		cliente.setCnpj(1L);
//		cliente.setTelefone(2L);
//		cliente.setEmail("");
//		cliente.setEndereco("Rua Luis Souza");
//		cliente.setEntrega("O mesmo");
//		cliente.setLimiteCredito(24.000);

//		BaseResponse base = service.inserir(cliente);
//
//		Assertions.assertEquals(400, base.getStatusCode());
//		Assertions.assertEquals("Por favor informe os dados do cliente...", base.getMessage());
//
//	}
//}
