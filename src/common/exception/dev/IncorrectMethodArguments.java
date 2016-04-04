package common.exception.dev;

/**
 * @author IsilinBN
 *
 */
public class IncorrectMethodArguments extends Exception {
	private static final long serialVersionUID = 1L;

	private String concernedClass = "";
	private String concernedMethod = "";
	
	/**
	 * @param concernedClass
	 * @param concernedMethod
	 */
	public IncorrectMethodArguments(String concernedClass, String concernedMethod) {
		this.concernedClass = concernedClass;
		this.concernedMethod = concernedMethod;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		String message = "Arguments of the method " + this.concernedMethod + " from the class " 
				+ this.concernedClass + " are incorrect.";
		return message;
	}
}
