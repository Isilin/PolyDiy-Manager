package persistent.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.exception.dev.NotExistingTuple;

/**
 * @author IsilinBN
 *
 */
public class JDBCAccountTest {
	private JDBCAccount account = null;

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
	 * Test method for {@link persistent.jdbc.JDBCAccount#JDBCAccount()}.
	 */
	@Test
	public void testJDBCAccount() {
		try {
			this.account = new JDBCAccount();
			assertFalse(this.account.isExisting());
			assertFalse(this.account.hasChanged());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCAccount#isExisting()}.
	 */
	@Test
	public void testIsExisting() {
		try {
			this.account = new JDBCAccount();
			this.account.loadFromKeys(Arrays.asList("ID"), Arrays.asList("1"));
			assertTrue(this.account.isExisting());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCAccount#hasChanged()}.
	 */
	@Test
	public void testHasChanged() {
		try {
			this.account = new JDBCAccount();
			this.account.loadFromKeys(Arrays.asList("ID"), Arrays.asList("1"));
			this.account.setLogin("bulup");
			assertTrue(this.account.hasChanged());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCAccount#loadFromKeys(java.util.List, java.util.List)}.
	 */
	@Test
	public void testLoadFromKeys() {
		try {
			this.account = new JDBCAccount();
			this.account.loadFromKeys(Arrays.asList("ID"), Arrays.asList("1"));
			assertEquals(this.account.getLogin(), "nas");
			assertEquals(this.account.getPassword(), "ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb");
			assertEquals(this.account.getID(), 1);
			assertTrue(this.account.isUser());
			assertFalse(this.account.isAdmin());
			assertEquals(this.account.getCommentIDs().size(), 1);
			assertEquals(this.account.getTutorialIDs().size(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCAccount#insert()}.
	 */
	@Test
	public void testInsert() {
		try {
			this.account = new JDBCAccount();
			assertFalse(this.account.isExisting());
			this.account.setLogin("yolo");
			this.account.setPassword("yolo");
			this.account.insert();
			this.account.loadFromKeys(Arrays.asList("login"), Arrays.asList("yolo"));
			assertTrue(this.account.isExisting());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCAccount#update()}.
	 */
	@Test
	public void testUpdate() {
		try {
			this.account = new JDBCAccount();
			this.account.loadFromKeys(Arrays.asList("login"), Arrays.asList("yolo"));
			this.account.setPassword("yolo2");
			assertTrue(this.account.hasChanged());
			this.account.update();
			assertFalse(this.account.hasChanged());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link persistent.jdbc.JDBCAccount#delete()}.
	 */
	@Test
	public void testDelete() {
		try {
			this.account = new JDBCAccount();
			try {
				this.account.loadFromKeys(Arrays.asList("login"), Arrays.asList("yolo"));
			} catch(NotExistingTuple e) {
				this.account.setLogin("yolo");
				this.account.setPassword("yolo");
				this.account.insert();
				this.account.loadFromKeys(Arrays.asList("login"), Arrays.asList("yolo"));
			}
			assertTrue(this.account.isExisting());
			this.account.delete();
			assertFalse(this.account.isExisting());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
