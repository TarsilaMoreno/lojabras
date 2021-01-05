package br.lojabras.app.api;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Bean
	public RestTemplate rest() {
	    return new RestTemplate();
	}
	
	@Bean
	public URI cepURI() throws URISyntaxException {
		return new URI("https://viacep.com.br/ws/17015270/json/unicode/");
	}
}
