package model.exceptions;

public class ContaNulaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ContaNulaException(String message) {
        super(message);
    }
}