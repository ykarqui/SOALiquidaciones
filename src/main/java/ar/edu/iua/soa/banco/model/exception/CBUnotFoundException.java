package ar.edu.iua.soa.banco.model.exception;

public class CBUnotFoundException extends Exception{
	public CBUnotFoundException() {
		super();
	}

	public CBUnotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CBUnotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CBUnotFoundException(String message) {
		super(message);
	}

	public CBUnotFoundException(Throwable cause) {
		super(cause);
	}
}