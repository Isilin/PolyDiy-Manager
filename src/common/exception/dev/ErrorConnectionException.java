package common.exception.dev;

/**
 * This exception is thrown when connection to the database is impossible.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class ErrorConnectionException extends Exception {
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		String message = "Error : connection to DataBase impossible.";
		return message;
	}
}
