package model.exceptions;

public class ValorNegativoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValorNegativoException(String message) {
		super(message);
	}
}
