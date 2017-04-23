package exceptions;

public class ErrorNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public ErrorNotFound() {
		super("Not found");
	}
}
