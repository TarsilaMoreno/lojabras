package br.lojabras.app.validation.exception;

public class RelatorioNaoExisteException extends RuntimeException{

	
	private static final long serialVersionUID = 9083406844467116121L;
	
	public RelatorioNaoExisteException() {
		super("Relatorio_Nao_Existe_Ou_Nao_Foi_Informado");
	}

	public RelatorioNaoExisteException(String message) {
		super(message);
	}
}
