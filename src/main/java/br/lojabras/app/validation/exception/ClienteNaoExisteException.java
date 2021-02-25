package br.lojabras.app.validation.exception;

public class ClienteNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = -7249348923723175500L;

	public ClienteNaoExisteException() {
		super("Cliente_Nao_Existe_Ou_Nao_Foi_Informado");
	}

	public ClienteNaoExisteException(String message) {
		super(message);
	}
}
