package common.exception.dev;

/**
 * @author IsilinBN
 *
 */
public class UnknowFactory extends Exception {
	private static final long serialVersionUID = 1L;

	private String nameFactory = "";
	
	/**
	 * Constructor of the exception UnknowFactory.
	 * @param nameFactory
	 */
	public UnknowFactory(String nameFactory) {
		this.nameFactory = nameFactory;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		String message = "The factory " + this.nameFactory + " is unknown.";
		return message;
	}
}
