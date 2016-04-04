/**
 * 
 */
package persistent.jdbc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.exception.dev.NotExistingTuple;

/**
 * @author IsilinBN
 *
 */
public class JDBCUserTest {
	private JDBCUser user = null;

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
	 * Test method for {@link persistent.jdbc.JDBCUser#JDBCUser()}.
	 */
	@Test
	public void testJDBCUser() {
		try {
			this.user = new JDBCUser();
			assertFalse(this.user.isExisting());
			assertFalse(this.user.hasChanged());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCUser#isExisting()}.
	 */
	@Test
	public void testIsExisting() {
		try {
			this.user = new JDBCUser();
			this.user.loadFromKeys(Arrays.asList("ID"), Arrays.asList("1"));
			assertTrue(this.user.isExisting());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCUser#hasChanged()}.
	 */
	@Test
	public void testHasChanged() {
		try {
			this.user = new JDBCUser();
			this.user.loadFromKeys(Arrays.asList("ID"), Arrays.asList("1"));
			this.user.setIDaccount(6);
			assertTrue(this.user.hasChanged());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCUser#loadFromKeys(java.util.List, java.util.List)}.
	 */
	@Test
	public void testLoadFromKeys() {
		try {
			this.user = new JDBCUser();
			this.user.loadFromKeys(Arrays.asList("ID"), Arrays.asList("1"));
			assertEquals(this.user.getIDaccount(), 2);
			// TODO complete other assert.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCUser#insert()}.
	 */
	@Test
	public void testInsert() {
		try {
			this.user = new JDBCUser();
			assertFalse(this.user.isExisting());
			this.user.setIDaccount(6);
			this.user.insert();
			this.user.loadFromKeys(Arrays.asList("IDaccount"), Arrays.asList(Integer.toString(6)));
			assertTrue(this.user.isExisting());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCUser#update()}.
	 */
	@Test
	public void testUpdate() {
		try {
			this.user = new JDBCUser();
			this.user.loadFromKeys(Arrays.asList("IDaccount"), Arrays.asList(Integer.toString(6)));
			this.user.setIDaccount(7);
			assertTrue(this.user.hasChanged());
			this.user.update();
			assertFalse(this.user.hasChanged());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCUser#delete()}.
	 */
	@Test
	public void testDelete() {
		try {
			this.user = new JDBCUser();
			try {
				this.user.loadFromKeys(Arrays.asList("IDaccount"), Arrays.asList(Integer.toString(7)));
			} catch(NotExistingTuple e) {
				this.user.setIDaccount(7);
				this.user.insert();
				this.user.loadFromKeys(Arrays.asList("IDaccount"), Arrays.asList(Integer.toString(7)));
			}
			assertTrue(this.user.isExisting());
			this.user.delete();
			assertFalse(this.user.isExisting());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
