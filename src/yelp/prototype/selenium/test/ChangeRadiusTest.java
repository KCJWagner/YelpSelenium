package yelp.prototype.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChangeRadiusTest {
	private YelpPage testPage;

	@Before
	public void setUp() throws Exception {
		testPage = new YelpPage();
	}

	@Test
	public void testChangeRadius() throws Exception {
		testPage.openPage();
		testPage.moveRadiusSlider(50);
		assertTrue(testPage.getCircleRadius().matches("^80[\\s\\S]*$"));
	}

	@After
	public void tearDown() throws Exception {
		testPage.closePage();
	}
}
