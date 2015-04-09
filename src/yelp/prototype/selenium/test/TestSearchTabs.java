package yelp.prototype.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSearchTabs {
	private static YelpPage testPage;

	@BeforeClass
	public static void setUp() throws Exception {
		testPage = new YelpPage();
		testPage.openPage();
	}
	
	@Before
	public void refresh(){
		testPage.refreshPage();
	}

	@Test
	public void testTestCase11() throws Exception {
		assertTrue(testPage.isElementVisible("id=locationPanel"));
		assertFalse(testPage.isElementVisible("id=costPanel"));
		
		testPage.goToCost();;
		assertTrue(testPage.isElementVisible("id=costPanel"));
		assertFalse(testPage.isElementVisible("id=locationPanel"));
		
		testPage.goToCuisine();
		assertTrue(testPage.isElementVisible("id=cuisinePanel"));
		assertFalse(testPage.isElementVisible("id=costPanel"));
		
		testPage.goToRatings();
		assertTrue(testPage.isElementVisible("id=ratingsPanel"));
		assertFalse(testPage.isElementVisible("id=cuisinePanel"));

		testPage.goToFeatures();
		assertTrue(testPage.isElementVisible("id=featuresPanel"));
		assertFalse(testPage.isElementVisible("id=ratingsPanel"));

		testPage.goToLocation();
		assertTrue(testPage.isElementVisible("id=locationPanel"));
		assertFalse(testPage.isElementVisible("id=featuresPanel"));

		testPage.goToCost();
		assertTrue(testPage.isElementVisible("id=costPanel"));
		assertFalse(testPage.isElementVisible("id=locationPanel"));

		testPage.goToLocation();
		assertTrue(testPage.isElementVisible("id=locationPanel"));
		assertFalse(testPage.isElementVisible("id=costPanel"));

	}

	@After
	public void tearDown() throws Exception {
		testPage.closePage();
	}
}
