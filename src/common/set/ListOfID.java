package common.set;

import java.util.ArrayList;

import common.exception.dev.NotFoundParameter;

public class ListOfID extends ArrayList<Integer> {
	private static final long serialVersionUID = 1L;
	
	private String attribute = "";
	private String concernedClass = "";
	
	public ListOfID(String attribute, String concernedClass) {
		super();
		this.attribute = attribute;
		this.concernedClass = concernedClass;
	}

	public Integer getID(int index) throws NotFoundParameter{
		if(this.get(index) == -1) {
			throw new NotFoundParameter(attribute, concernedClass);
		}
		return this.get(index);
	}
}
