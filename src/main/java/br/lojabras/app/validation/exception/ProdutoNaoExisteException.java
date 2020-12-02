package br.lojabras.app.validation.exception;

public class ProdutoNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = -7249348923723175500L;
	
	public ProdutoNaoExisteException() {
		super("Produto_Nao_Existe_Ou_Nao_Foi_Informado");
	}
	
	public ProdutoNaoExisteException(String message) {
		super(message);
	}
}
