package persistent.common;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import common.exception.dev.UnknowFactory;
import common.parameter.ApplicationParameter;

/**
 * @author IsilinBN
 *
 */
public class GlobalFactory<T> {
	/**
	 * @param nameFactory
	 * @return the factory asked with the true way of build.
	 * @throws UnknowFactory
	 */
	@SuppressWarnings("unchecked")
	public static <T> T buildFactory(Class<T> classObject) throws UnknowFactory {
		ObjectMapper mapper = new ObjectMapper();
		String factory = classObject.getName();
		try {
			ApplicationParameter parameters = mapper.readValue(new File("src/config/application.json"), 
																ApplicationParameter.class);
			String methodFactory = parameters.getFactory();
			
			int cut = factory.lastIndexOf(".");
			factory = factory.substring(0, cut + 1) + methodFactory.toLowerCase() + "." 
						+ methodFactory + factory.substring(cut + 1);
			
			return (T) Class.forName(factory).getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new UnknowFactory(factory);
	}
}
