package br.lojabras.app.util;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


import br.lojabras.app.response.exception.ErrorApiException;

@Component
public class ResponseUtilHelper {

	@Autowired
	private ObjectMapper mapper;

	public <T> T read(Response response, Class<T> aClass) throws ErrorApiException {
		final String body = response.readEntity(String.class);
		try {
			if (isSuccess(response)) {
				return mapper.readValue(body, aClass);
			} else {
				throw new ErrorApiException(body);
			}
		} catch (IOException e) {
			throw new ErrorApiException(e.getMessage());
		}
	}

	public String write(Object object) throws ErrorApiException {
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			throw new ErrorApiException(e.getMessage());
		}
	}

	public boolean isSuccess(Response response) {
		return response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL);
	}

}
