package br.lojabras.app.validation.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.lojabras.app.response.BaseResponse;

@ControllerAdvice
public class ExceptionMapper {

	@ExceptionHandler(value = ProdutoNaoExisteException.class)
	public ResponseEntity<Object> exception(ProdutoNaoExisteException exception) {
		return new ResponseEntity<>(new BaseResponse(1,exception.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public ResponseEntity<Object> exception(EmptyResultDataAccessException exception) {
		return new ResponseEntity<>(new BaseResponse(exception.getActualSize() ,exception.getMessage()), HttpStatus.NOT_FOUND);
	}
	
}
