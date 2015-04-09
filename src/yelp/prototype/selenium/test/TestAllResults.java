package yelp.prototype.selenium.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAllResults {
	private static YelpPage testPage;
	private String location = "Kitsilano";
	private String cuisine = "Sushi";
	private int priceMin;
	private int priceMax;

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
	public void testTestCase10() throws Exception {
		setSearchSettings();
		checkSearchResults();
	}
	
	private void checkSearchResults() {
		testPage.goToResults();
		checkCuisine();
		checkCost();
		checkRating();
		checkFeatures();		
	}
	
	private void setSearchSettings() {
		testPage.enterLocation(location);
		testPage.moveRadiusSlider(200);
		testPage.goToCost();
		priceMin = testPage.moveMinPriceSlider(25);
		priceMax = testPage.moveMaxPriceSlider(25);
		testPage.goToCuisine();
		testPage.enterCuisine(cuisine);
		testPage.goToRatings();
		testPage.toggle5Star();
		testPage.toggle4Star();
		testPage.toggle3Star();
		testPage.toggle1Star();
		testPage.goToFeatures();
		testPage.toggleAcceptCredit();
	}
	
	
	private void checkCuisine() {
		List<String> cuisineResults = testPage.getResults("Cuisine");
		// Check that cuisines are indeed the entered name
		for (int i = 0; i < cuisineResults.size(); i++){
			assertTrue(cuisineResults.get(i).equals(cuisine));
		}
	}
	
	private void checkCost() {	
		List<String> costs = testPage.getResults("Cost");
		// Check that price is within specified ranges
		for (int i = 0; i < costs.size(); i++){
			int price = Integer.parseInt(costs.get(i));
			assertTrue(price >= priceMin && price <= priceMax);
		}
	}
	
	private void checkRating() {
		List<String> ratingResults = testPage.getResults("Rating");
		// Check that ratings are indeed the entered rating
		for (int i = 0; i < ratingResults.size(); i++){
			assertTrue(ratingResults.get(i).equals("2"));
		}
	}
	
	private void checkFeatures() {
		List<String> featureResults = testPage.getResults("Features");
		// Check that features are indeed the entered features
		for (int i = 0; i < featureResults.size(); i++){
			assertTrue(featureResults.get(i).equals("Card"));
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		testPage.closePage();
	}
}
