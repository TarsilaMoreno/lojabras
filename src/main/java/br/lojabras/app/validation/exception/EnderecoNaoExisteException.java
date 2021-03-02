package br.lojabras.app.validation.exception;

public class EnderecoNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = -5451853386036095156L;

	public EnderecoNaoExisteException() {
		super("Endereco_Nao_Existe_Ou_Nao_foi_informado");

	}

	public EnderecoNaoExisteException(String message) {
		super(message);
	}
}
