package yelp.prototype.selenium.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

@SuppressWarnings("deprecation")
public class YelpPage{
	/* TO BE REMOVED */
	private final static String KEVIN = "file:///C:/Users/Kevin/Documents/4th Year/CPSC 344/Main Project/YelpPrototype/index.html";
	private final static String KEVIN_CHROMEDRIVER = "C:/Users/Kevin/Documents/4th Year/EECE 416/Workspace/chromedriver.exe";
	private final static String DANIEL = "file:///C:/Users/Daniel/Desktop/ece416Asn4/YelpPrototype/index.html";
	private final static String DANIEL_CHROMEDRIVER = "C:/eclipse/selenium_chromedriver_win32/chromedriver.exe";
	private final static String JUNG = "file:///C:/Users/Jung/Documents/YelpPrototype-master/index.html";
	private final static String JUNG_CHROMEDRIVER = "C:/Program Files/eclipse/selenium_chromedriver_win32/chromedriver.exe";
	/* ----- */
	
	private final static String BASE_URL = KEVIN;
	private final static String CHROMEDRIVER = KEVIN_CHROMEDRIVER;
	private final WebDriver driver;
	private final Selenium selenium;
	private final static String LOCATION_ID = "id=ui-id-5";
	private final static String COST_ID = "id=ui-id-6";
	private final static String CUISINE_ID = "id=ui-id-7";
	private final static String RATINGS_ID = "id=ui-id-8";
	private final static String FEATURES_ID = "id=ui-id-9";
	private final static String RESULTS_ID = "id=seeResults";
	private final static String CIRCLE_ID = "id=radius";
	private final static String RESULT_DIV_ID = "results";
	private final static String RESULT_CLASS_ID = "restDiv";
	private final static String INDIV_RESULT_ID = "//div[@id='restNum[i]']";
	private final static String RADIUS_SLIDER = "//div[@id='locationPanel']/div[3]/span";
	private final static String MINCOST_SLIDER_ID = "//div[@id='costPanel']/div[2]/span";
	private final static String MAXCOST_SLIDER_ID = "//div[@id='costPanel']/div[2]/span[2]";
	private final static String CUISINE_INPUT_ID = "//div[@id='cuisinePanel']/ul/li[i]/input";
	private final static String RESULT_INFO_ID = "//div[2]/div[i]/div[2]";
	private final static String LOCATION_INPUT_ID = "css=#locationPanel input.ui-widget-content.ui-autocomplete-input";
	private final static String LOCATION_INPUT_ID_KEY = "input.ui-widget-content.ui-autocomplete-input";
	private final static String LOCATION_COUNT_ATTRIBUTE = "#locationPanel .tagit-choice";
	private final static String CIRCLE_RADIUS_ATTRIBUTE = "css=svg circle#radius@r";
	private final static String CIRCLE_XPOS_ATTRIBUTE = "css=svg circle#radius@cx";
	private final static String CIRCLE_YPOS_ATTRIBUTE = "css=svg circle#radius@cy";
	private final static String CIRCLE_RESTAURANTS_SIZE_ATTR = "css=svg circle#restaurant[i]@r";
	private final static String CIRCLE_RESTAURANTS_OPACITY_ATTR = "css=svg circle#restaurant[i]@fill-opacity";
	private final static String RATING_INPUT_ID = "css=#ratingsPanel input";
	private final static String FEATURES_INPUT_ID = "css=#featuresPanel input";
	private final static String ONE_STAR_ID = "xpath=(//input[@type='checkbox'])[5]";
	private final static String TWO_STAR_ID = "xpath=(//input[@type='checkbox'])[4]";
	private final static String THREE_STAR_ID = "xpath=(//input[@type='checkbox'])[3]";
	private final static String FOUR_STAR_ID = "xpath=(//input[@type='checkbox'])[2]";
	private final static String FIVE_STAR_ID = "xpath=(//input[@type='checkbox'])[1]";
	private final static String ACCEPT_CREDIT_ID = "css=#featuresPanel > input[type=\"checkbox\"]";
	private final static String START_OVER_ID = "id=startOver";
	
	private final static int RESULT_OFFSET_RATING = 0;
	private final static int RESULT_OFFSET_CUISINE = 1;
	private final static int RESULT_OFFSET_COST = 2;
	private final static int RESULT_OFFSET_FEATURES = 3;
	private final static int CIRCLE_RESTAURANTS_VISIBLE = 1;
	private final static int CIRCLE_RESTAURANTS_HIGHLIGHTEDSIZE = 5;
	
	// Chrome is needed for TestMoveCircle to pass as the circle cannot be moved in Firefox
	public YelpPage(){
		System.setProperty("webdriver.chrome.driver", CHROMEDRIVER);		
		this.driver = new ChromeDriver();
		this.selenium = new WebDriverBackedSelenium(this.driver, BASE_URL);
	}
	
	// Loads the page
	public YelpPage openPage(){
		selenium.open(BASE_URL);
		return this;
	}
	
	// Refreshes the page
	public YelpPage refreshPage(){
		driver.navigate().refresh();
		return this;
	}
	
	public void closePage(){
		selenium.stop();
	}
	
	// Opens the 'Location' tab
	public YelpPage goToLocation(){
		selenium.click(LOCATION_ID);
		waitFor(500);
		return this;
	}
	
	// Opens the 'Cost' tab
	public YelpPage goToCost(){
		selenium.click(COST_ID);
		waitFor(500);
		return this;
	}
	
	// Opens the 'Cuisine' tab
	public YelpPage goToCuisine(){
		selenium.click(CUISINE_ID);
		waitFor(500);
		return this;
	}

	// Opens the 'Ratings' tab
	public YelpPage goToRatings(){
		selenium.click(RATINGS_ID);
		waitFor(500);
		return this;
	}
	
	// Opens the 'Features' tab
	public YelpPage goToFeatures(){
		selenium.click(FEATURES_ID);
		waitFor(500);
		return this;
	}
	
	// Opens the 'Results' tab
	public YelpPage goToResults(){
		selenium.click(RESULTS_ID);
		waitFor(500);
		return this;
	}
	
	// Toggle the 1 star rating
	public YelpPage toggle1Star(){
		selenium.click(ONE_STAR_ID);
		return this;
	}
	
	// Toggle the 2 star rating
	public YelpPage toggle2Star(){
		selenium.click(TWO_STAR_ID);
		return this;
	}
	
	// Toggle the 3 star rating
	public YelpPage toggle3Star(){
		selenium.click(THREE_STAR_ID);
		return this;
	}
	
	// Toggle the 4 star rating
	public YelpPage toggle4Star(){
		selenium.click(FOUR_STAR_ID);
		return this;
	}
	
	// Toggle the 5 star rating
	public YelpPage toggle5Star(){
		selenium.click(FIVE_STAR_ID);
		return this;
	}
	
	// Toggle the accept credit feature
	public YelpPage toggleAcceptCredit(){
		selenium.click(ACCEPT_CREDIT_ID);
		return this;
	}
	
	// Clicks the 'Start Fresh' button
	public YelpPage startOver(){
		selenium.click(START_OVER_ID);
		return this;
	}
	
	// Waits for time milliseconds
	public YelpPage waitFor(int time){
		selenium.waitForPageToLoad(((Integer) time).toString());
		return this;
	}
	
	// Enters the location specified in the location input field
	public YelpPage enterLocation(String location){
		waitFor(500);
		selenium.type(LOCATION_INPUT_ID, location);
		driver.findElement(By.cssSelector(LOCATION_INPUT_ID_KEY)).sendKeys(Keys.ENTER);
		return this;
	}
	
	// Enters the cuisine specified in the cuisine input field
	public YelpPage enterCuisine(String cuisine){
		enterCuisine(cuisine, 1);
		return this;
	}
	
	// Enters the cuisines specified in the cuisine input field
	public YelpPage enterCuisine(String[] cuisines){
		for (int i = 0; i < cuisines.length; i++){
			enterCuisine(cuisines[i], i+1);
		}
		return this;
	}
	
	private void enterCuisine(String cuisine, int i){
		waitFor(500); // allow the program some time to settle: prevents element not visible exception
		String thisID = CUISINE_INPUT_ID.replace("[i]", "[" + ((Integer) i).toString() + "]");
		selenium.type(thisID, cuisine);
		driver.findElement(By.xpath(thisID)).sendKeys(Keys.ENTER);
	}

	// Returns the position of the radius circle: [x, y]
	public int[] getRadiusPosition(){
		String x_string = selenium.getAttribute(CIRCLE_XPOS_ATTRIBUTE);
		String y_string = selenium.getAttribute(CIRCLE_YPOS_ATTRIBUTE);
		if (x_string.indexOf(".") != -1){
			x_string = x_string.substring(0, x_string.indexOf("."));
		}
		if (y_string.indexOf(".") != -1){
			y_string = y_string.substring(0, y_string.indexOf("."));
		}
		int x = Integer.parseInt(x_string);
		int y = Integer.parseInt(y_string);

		int[] coord = {x, y};
		return coord;
	}
	
	// Moves the radius circle on the map by horPixel horizontally and verPixel vertically
	public YelpPage moveCircle(int hPixel, int vPixel){
		selenium.dragAndDrop(CIRCLE_ID, ((Integer) hPixel).toString() + "," + ((Integer) vPixel).toString());
		return this;
	}
	
	// Moves the radius slider by size pixel horizontally
	// Returns the set radius
	public int moveRadiusSlider(int pixel){
		selenium.dragAndDrop(RADIUS_SLIDER, ((Integer) pixel).toString() + ",0");
		String radius = selenium.getText(RADIUS_SLIDER + "/span");
		return Integer.parseInt(radius);
	}
	
	// Moves the price slider by size pixel horizontally
	// Returns the set minimum price
	public int moveMinPriceSlider(int pixel){
		selenium.dragAndDrop(MINCOST_SLIDER_ID, ((Integer) pixel).toString() + ",0");
		String priceMin = selenium.getText(MINCOST_SLIDER_ID + "/span");
		return Integer.parseInt(priceMin);
	}
	
	// Moves the price slider by size pixel horizontally
	// Returns the set maximum price
	public int moveMaxPriceSlider(int pixel){
		selenium.dragAndDrop(MAXCOST_SLIDER_ID, ((Integer) pixel).toString() + ",0");
		String priceMax = selenium.getText(MAXCOST_SLIDER_ID + "/span");
		return Integer.parseInt(priceMax);
	}
	
	// Hovers over the specified restaurant in the result tab
	public YelpPage hoverOverResult(String restNum){
		String thisID = INDIV_RESULT_ID.replace("[i]", restNum);
		selenium.mouseOver(thisID);
		waitFor(100);
		return this;
	}
	
//	Get the value in the location text box
	public String getLocation(){
		return selenium.getValue(LOCATION_INPUT_ID);
	}
	
//	Get the number of locations entered in the location text box
	public int getNumberLocations(){
		return driver.findElements(By.cssSelector(LOCATION_COUNT_ATTRIBUTE)).size();
	}
	
//	Get the value of the radius slider
	public String getRadiusSlider(){
		return selenium.getText(RADIUS_SLIDER);
	}
	
//	Get the value of the min price slider
	public String getMinPriceSlider(){
		return selenium.getText(MINCOST_SLIDER_ID);
	}
	
//	Get the value of the max price slider
	public String getMaxPriceSlider(){
		return selenium.getText(MAXCOST_SLIDER_ID);
	}
	
//	Check if all ratings are currently checked
	public boolean areAllRatingsChecked(){
		return selenium.isChecked(RATING_INPUT_ID);
	}
	
//	Check if all features are currently checked
	public boolean areAllFeaturesChecked(){
		return selenium.isChecked(FEATURES_INPUT_ID);
	}
	
//	Get the radius of the circle on the map
	public String getCircleRadius(){
		return selenium.getAttribute(CIRCLE_RADIUS_ATTRIBUTE);
	}
	
	public boolean isElementVisible(String elementID){
		return selenium.isVisible(elementID);
	}
	
	// Returns a string list of resulting restaurant info
	public List<String> getResults(){
		List<String> results = new ArrayList<String>();
		// Traverse through all the available restaurant and extract info in string
		try{
			for (int i = 1; i > 0; i++){
				String thisID = RESULT_INFO_ID.replace("[i]", "[" + ((Integer) i).toString() + "]");
				String result = selenium.getText(thisID);
				results.add(result);
			}
		}		
		// Reach end of result
		catch (SeleniumException e){
			return results;
		}
		return null;
	}
	
	// Returns a string list of resulting restaurant id from results tab
	public List<String> getResultIDsFromTab(){
		List<String> ids = new ArrayList<String>();
		List<WebElement> childs = driver.findElement(By.id(RESULT_DIV_ID)).findElements(By.className(RESULT_CLASS_ID));
		for (int i = 0; i < childs.size(); i++){
			String thisID = getElementID(childs.get(i).getAttribute("id"));;
			ids.add(thisID);
		}
		return ids;
		
	}
	
	private String getElementID(String elementName){
		String numbersOnly = elementName.replaceAll("[^0-9]",  "");
		return numbersOnly;
	}
	
	// Returns a string list of filtered info of resulting restaurant
	// Based on Rating / Cuisine / Cost / Features
	public List<String> getResults(String option){
		List<String> results;
		switch (option){
		case "Rating":	
			results = getResults();
			return extractRating(results);
			
		case "Cuisine":	
			 results = getResults();
			return extractCuisine(results);
			
		case "Cost":
			results = getResults();
			return extractCost(results);
			
		case "Features":
			results = getResults();
			return extractFeatures(results);
			
		default:
			return null;
		}
	}
	
	private List<String> extractRating(List<String> results){
		List<String> ratings = new ArrayList<String>();
		for (int i = 0; i < results.size(); i++){
			String rating = results.get(i).split("\n")[RESULT_OFFSET_RATING];
			rating = rating.replace("Rating: ", "");
			ratings.add(rating);
		}
		return ratings;
	}
	
	private List<String> extractCuisine(List<String> results){
		List<String> cuisines = new ArrayList<String>();
		for (int i = 0; i < results.size(); i++){
			String cuisine = results.get(i).split("\n")[RESULT_OFFSET_CUISINE];
			cuisine = cuisine.replace("Cuisine: ", "");
			cuisines.add(cuisine);
		}
		return cuisines;
	}

	private List<String> extractCost(List<String> results){
		List<String> prices = new ArrayList<String>();
		for (int i = 0; i < results.size(); i++){
			String price = results.get(i).split("\n")[RESULT_OFFSET_COST];
			price = price.replace("Avg Cost: $", "");
			price = price.replace("/main", "");
			prices.add(price);
		}
		return prices;
	}

	private List<String> extractFeatures(List<String> results){
		List<String> features = new ArrayList<String>();
		for (int i = 0; i < results.size(); i++){
			String feature = results.get(i).split("\n")[RESULT_OFFSET_FEATURES];
			feature = feature.replace("Features: ", "");
			features.add(feature);
		}
		return features;
	}
	
	// Returns a boolean whether the specified restaurant on the map is highlighted
	public boolean checkHighlighted(String restNum){
		String thisID = CIRCLE_RESTAURANTS_SIZE_ATTR.replace("[i]", restNum);
		String pointSize = selenium.getAttribute(thisID);
		if (Integer.parseInt(pointSize) == CIRCLE_RESTAURANTS_HIGHLIGHTEDSIZE)
			return true;
		else
			return false;
	}
	
	// Returns a boolean whether the specified restaurant on the map is visible
	public boolean checkVisible(String restNum){
		String thisID = CIRCLE_RESTAURANTS_OPACITY_ATTR.replace("[i]", restNum);
		String pointOpacity = selenium.getAttribute(thisID);
		if (Integer.parseInt(pointOpacity) == CIRCLE_RESTAURANTS_VISIBLE)
			return true;
		else
			return false;
	}
}