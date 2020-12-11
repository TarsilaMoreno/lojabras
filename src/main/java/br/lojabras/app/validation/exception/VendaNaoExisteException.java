package br.lojabras.app.validation.exception;

public class VendaNaoExisteException extends RuntimeException {
	

	private static final long serialVersionUID = -8163602625043448172L;

	public VendaNaoExisteException() {
		super("Venda_Nao_Existe_Ou_Nao_Foi_Informada");
	}
	
	public VendaNaoExisteException(String message) {
		super(message);
	}
}


