package common.exception.dev;

/**
 * Throw this exception if the syntax of the query is incorrect.
 */
public class JDBCQueryException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String query = "";

	/**
	 * Constructor of the exception.
	 * @param query - query which has incorrect syntax.
	 */
	public JDBCQueryException(String query) {
		this.query = query;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		String message = "The query's syntaxe is incorrect : \"" + this.query + "\".";
		return message;
	}
}
