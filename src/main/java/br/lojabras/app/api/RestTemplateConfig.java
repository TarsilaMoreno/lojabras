package br.lojabras.app.api;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplateConfig {
	
	private static final String CEP_API = "https://viacep.com.br/ws";
	
	private static final String BANCO_API = "https://brasilapi.com.br/api";
	

	@Bean
	public WebTarget target() {
		return ClientBuilder.newClient().target(CEP_API);
	}
	@Bean
	public WebTarget targetBrasilApi() {
		return ClientBuilder.newClient().target(BANCO_API);
	}
	
}
