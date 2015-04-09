package yelp.prototype.selenium.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCuisine {
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
	public void testOneCuisine(){
		String name = "Italian";
		testPage.goToCuisine();
		testPage.enterCuisine(name);
		List<String> cuisines = testPage.getResults("Cuisine");
		// Check that cuisines are indeed the entered name
		for (int i = 0; i < cuisines.size(); i++){
			assertTrue(cuisines.get(i).equals(name));
		}
	}
	
	@Test
	public void testTwoCuisines(){
		String[] names = {"French", "Mexican"};
		testPage.goToCuisine();
		testPage.enterCuisine(names);
		List<String> cuisines = testPage.getResults("Cuisine");
		// Check that cuisines are indeed the entered name
		for (int i = 0; i < cuisines.size(); i++){
			assertTrue(cuisines.get(i).equals(names[0]) || cuisines.get(i).equals(names[1]));
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		testPage.closePage();
	}
}
