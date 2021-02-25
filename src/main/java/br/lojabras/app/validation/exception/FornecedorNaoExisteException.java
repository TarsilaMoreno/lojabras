package br.lojabras.app.validation.exception;

public class FornecedorNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = -7249348923723175500L;
	
	public FornecedorNaoExisteException() {
		super("Fornecedor_Nao_Existe_Ou_Nao_Foi_Informado");
	}
	
	public FornecedorNaoExisteException(String message) {
		super(message);
	}

}
