package common.exception.dev;

public class NotFoundParameter extends Exception {
	private static final long serialVersionUID = 1L;
	private String attribute = "";
	private String concernedClass = "";
	
	public NotFoundParameter() {
	}
	
	public NotFoundParameter(String attribute) {
		this.attribute = attribute;
	}
	public NotFoundParameter(String attribute, String concernedClass) {
		this.attribute = attribute;
		this.concernedClass = concernedClass;
	}
	
	@Override
	public String getMessage() {
		String message = "The attribute requested has not been found.";
		if(!this.attribute.isEmpty()) {
			message += "(" + this.attribute;
			if(!this.concernedClass.isEmpty()) {
				message += " from " + this.concernedClass;
			}
			message += ")";
		}
		return message;
	}
}
