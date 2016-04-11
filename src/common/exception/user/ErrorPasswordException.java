package common.exception.user;

public class ErrorPasswordException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		String message = "The password is incorrect.";
		return message;
	}
}
