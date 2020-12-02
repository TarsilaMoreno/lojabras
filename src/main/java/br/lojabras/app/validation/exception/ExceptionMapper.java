package br.lojabras.app.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.lojabras.app.response.BaseResponse;

@ControllerAdvice
public class ExceptionMapper {

	@ExceptionHandler(value = ProdutoNaoExisteException.class)
	public ResponseEntity<Object> exception(ProdutoNaoExisteException exception) {
		return new ResponseEntity<>(new BaseResponse(), HttpStatus.NOT_FOUND);
	}
}
