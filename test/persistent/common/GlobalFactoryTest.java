/**
 * 
 */
package persistent.common;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.exception.dev.UnknowFactory;
import persistent.factory.SessionFactory;

/**
 * @author IsilinBN
 *
 */
public class GlobalFactoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link persistent.common.GlobalFactory#buildFactory(java.lang.String)}.
	 */
	@Test
	public void testBuildFactory() {
		try {
			SessionFactory factory = GlobalFactory.<SessionFactory>buildFactory(SessionFactory.class);
			assertNotNull(factory);
		} catch (UnknowFactory e) {
			fail("Error from loading class : " + e.getMessage());
		}
	}

}
