package br.lojabras.app.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseResponse {

	public int size;
	public String message;

	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
