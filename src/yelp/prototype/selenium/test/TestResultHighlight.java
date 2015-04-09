package yelp.prototype.selenium.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class TestResultHighlight {
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
	// Checks results without any additional filters
	public void testResultCustom1(){
		setSearchSettings("Arbutus", "Chinese", -10, 20);
		testPage.goToResults();
		List<String> resultIds = testPage.getResultIDsFromTab();
		for (int i = 0; i < resultIds.size(); i++){
			String currentId = resultIds.get(i);
			testPage.hoverOverResult(currentId);
			boolean currentHighlighted = testPage.checkHighlighted(currentId);
			assertTrue(currentHighlighted);
		}
	}
	
	@Test
	// Checks results with some filters
	public void testResultCustom2(){
		setSearchSettings("Dunbar", "Japanese", 0, 20);
		testPage.goToResults();
		List<String> resultIds = testPage.getResultIDsFromTab();
		for (int i = 0; i < resultIds.size(); i++){
			String currentId = resultIds.get(i);
			testPage.hoverOverResult(currentId);
			boolean currentHighlighted = testPage.checkHighlighted(currentId);
			assertTrue(currentHighlighted);
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		testPage.closePage();
	}
	
	private void setSearchSettings(String location, String cuisine, int price_dMin, int price_dMax) {
		testPage.enterLocation(location);
		testPage.goToCost();
		testPage.moveMinPriceSlider(price_dMin);
		testPage.moveMaxPriceSlider(price_dMax);
		testPage.goToCuisine();
		testPage.enterCuisine(cuisine);
	}
}
