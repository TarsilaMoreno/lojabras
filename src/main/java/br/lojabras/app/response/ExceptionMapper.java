package br.lojabras.app.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.lojabras.app.response.exception.ErrorApiException;
import br.lojabras.app.validation.exception.ProdutoNaoExisteException;
import springfox.documentation.service.ResponseMessage;

@ControllerAdvice
public class ExceptionMapper {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<Object> handleException(MethodArgumentNotValidException e) {
		List<BaseResponse> results = new ArrayList<BaseResponse>();
	  e.getBindingResult().getAllErrors()
	      .stream()
	      .filter(FieldError.class::isInstance)
	      .map(FieldError.class::cast)
	      .forEach(fieldError -> results.add(new BaseResponse(1, (fieldError.getField()+" - "+fieldError.getDefaultMessage()))));
	  return new ResponseEntity<>(results.isEmpty() ? e.getMessage() : results.get(0) , HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ProdutoNaoExisteException.class)
	public ResponseEntity<Object> exception(ProdutoNaoExisteException exception) {
		return new ResponseEntity<>(new BaseResponse(1, exception.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public ResponseEntity<Object> exception(EmptyResultDataAccessException exception) {
		return new ResponseEntity<>(new BaseResponse(exception.getActualSize(), exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ErrorApiException.class)
	public ResponseEntity<Object> exception(ErrorApiException exception) {
		return new ResponseEntity<>(new BaseResponse(1, exception.getMessage()), HttpStatus.NOT_FOUND);
	}

}
