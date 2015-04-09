package yelp.prototype.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StartFreshTest {
	private YelpPage testPage;

	@Before
	public void setUp() throws Exception {
		testPage = new YelpPage();
	}

	@Test
	public void testStartFresh() throws Exception {
		testPage.openPage();
		testPage.enterLocation("Kitsilano");
		testPage.moveRadiusSlider(50);
		testPage.goToCost();
		testPage.moveMinPriceSlider(50);
		testPage.moveMaxPriceSlider(50);
		testPage.goToCuisine();
		testPage.enterCuisine("Sushi");
		testPage.goToRatings();
		testPage.toggle1Star();
		testPage.toggle2Star();
		testPage.goToFeatures();
		testPage.toggleAcceptCredit();
		testPage.startOver();
		testPage.waitFor(30000);
		assertEquals("", testPage.getLocation());
		assertEquals(0, testPage.getNumberLocations());
		assertTrue(testPage.getRadiusSlider().matches("^[\\s\\S]*2[\\s\\S]*$"));
		assertEquals("5", testPage.getMinPriceSlider());
		assertEquals("20", testPage.getMaxPriceSlider());
		assertTrue(testPage.areAllRatingsChecked());
		assertFalse(testPage.areAllFeaturesChecked());
	}

	@After
	public void tearDown() throws Exception {
		testPage.closePage();
	}
}
