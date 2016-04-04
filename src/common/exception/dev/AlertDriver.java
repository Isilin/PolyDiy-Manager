package common.exception.dev;

/**
 * Throw this exception if PostgreSQL driver cannot be loaded.
 */
public class AlertDriver extends Exception {
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		String message = "PostgreSQL driver cannot be found.";
		return message;
	}
}
