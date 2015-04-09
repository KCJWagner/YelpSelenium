package yelp.prototype.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeLocationTest {
	private YelpPage testPage;
	
//	selenium = new DefaultSelenium("localhost", 4444, "*firefox", "file:///C:/Users/Kevin/Documents/4th Year/CPSC 344/Main Project/YelpPrototype/index.html");
//	selenium.start();
//}

//@Test
//public void testChangeLocation() throws Exception {
//	selenium.open("file:///C:/Users/Kevin/Documents/4th Year/CPSC 344/Main Project/YelpPrototype/index.html");

	@Before
	public void setUp() throws Exception {
		testPage = new YelpPage();
	}

	@Test
	public void testChangeLocation() throws Exception {
		testPage.openPage();
		testPage.enterLocation("Kitsilano");
		int [] circlePos = testPage.getRadiusPosition();
		assertEquals(362, circlePos[0]);
		assertEquals(55, circlePos[1]);
	}

	@After
	public void tearDown() throws Exception {
		testPage.closePage();
	}
}
