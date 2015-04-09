package yelp.prototype.selenium.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class TestPrice {
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
	public void testPricePosZero(){
		testPrice(30, 0);
	}
	
	@Test
	public void testPricePosNeg(){
		testPrice(30, -25);
	}
	
	@Test
	public void testPriceNegPos(){
		testPrice(-30, 20);
	}
	
	@Test
	public void testPriceZeroNeg(){
		testPrice(0, -30);
	}
	
	@Test
	public void testPriceDefault(){
		testPrice(0, 0);
	}
	
	/*
	 * Helper function for the test functions
	 */
	private void testPrice(int dX, int dY){
		testPage.goToCost();
		int priceMin = testPage.moveMinPriceSlider(dX);
		int priceMax = testPage.moveMaxPriceSlider(dY);
		List<String> costs = testPage.getResults("Cost");
		// Check that price is within specified ranges
		for (int i = 0; i < costs.size(); i++){
			int price = Integer.parseInt(costs.get(i));
			assertTrue(price >= priceMin && price <= priceMax);
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		testPage.closePage();
	}
}
