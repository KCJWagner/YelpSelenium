package yelp.prototype.selenium.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class TestResultVisible {
	private static YelpPage testPage;
	private String location = "Dunbar";
	private String cuisine = "Japanese";
	private int price_dMin = 0;
	private int price_dMax = 20;

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
	public void testResultDefault(){
		testPage.goToResults();
		List<String> resultIds = testPage.getResultIDsFromTab();
		for (int i = 0; i < resultIds.size(); i++){
			String currentId = resultIds.get(i);
			boolean currentVisible = testPage.checkVisible(currentId);
			assertTrue(currentVisible);
		}
	}
	
	@Test
	// Checks results with some filters
	public void testResultCustom(){
		setSearchSettings(location, cuisine, price_dMin, price_dMax);
		testPage.goToResults();
		List<String> resultIds = testPage.getResultIDsFromTab();
		for (int i = 0; i < resultIds.size(); i++){
			String currentId = resultIds.get(i);
			boolean currentVisible = testPage.checkVisible(currentId);
			assertTrue(currentVisible);
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
