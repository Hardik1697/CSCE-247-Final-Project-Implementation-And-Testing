import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDataLoader {

	DataLoader dL;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dL = new DataLoader();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadEmailForSignInUp1() {
		assertFalse(dL.loadEmailForSignUp("ishu"));
	}

	@Test
	public void testGetUserStatus()	{
		String status = "", status1 = "";
		assertEquals("Student", dL.getUserStatus("ha2", status));
		assertNotEquals("Admin", dL.getUserStatus("ta2", status1));
	}
	
	@Test
	public void testGetEventName() {
		assertTrue(dL.getEventName("The Jungle Book"));
		assertFalse(dL.getEventName("Test false"));
	}
	@Test
	public void testGetTheatertName() {
		assertTrue(dL.getTheaterName("AMC"));
		assertFalse(dL.getTheaterName("notthere"));
	}
	@Test
	public void testGetTheatertPrice() {
		assertEquals("9",dL.getTheaterPrice("AMC", "2"));
		assertNotEquals("10",dL.getTheaterPrice("notthere", "141"));
	}
	@Test
	public void testGetTheatertLocation() {
		String location = "";
		assertEquals("3400 Forest Dr Suite 3000, Columbia, SC 29204",dL.getTheaterLocation("Regal", location));
		assertNotEquals("10",dL.getTheaterLocation("notthere", "141"));
	}
	@Test
	public void testGetNumReviewsAll() {
		//could not fully test this one
		int num = 0;
		assertEquals(3, dL.getNumReviewsAll("ha2", num));
	}
	@Test
	public void testShowTimeNumber() {
		assertEquals(1, dL.showTimeNumber("Frozen 2", "AMC"));
	}
	
	@Test
	public void testLoadSpecificStuff() {
		String a = "";
		assertEquals(dL.loadSpecificStuff("Regal", a, "theater"), "Regal");
		assertNotEquals(dL.loadSpecificStuff("Regal", a, "theater"), "AMC");

	}
}
