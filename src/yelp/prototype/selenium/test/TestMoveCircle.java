package yelp.prototype.selenium.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMoveCircle{
	private static YelpPage testPage;

	@BeforeClass
	public static void setUp() throws Exception{
		testPage = new YelpPage();
		testPage.openPage();
	}
	
	@Test
	public void testMoveCirclePositive(){
		testMoveCircle(100, 100);
	}

	@Test
	public void testMoveCircleNegative(){
		testMoveCircle(-50, -50);
	}

	@Test
	public void testMoveCircleZero(){
		testMoveCircle(0, 0);
	}
	
	@Test
	public void testMoveCirclePosZero(){
		testMoveCircle(250, 0);
	}
	
	@Test
	public void testMoveCircleZeroNeg(){
		testMoveCircle(0, -50);
	}
	
	/*
	 * Helper function for the test functions
	 */
	private void testMoveCircle(int dX, int dY){
		int[] initialPos, finalPos;
		initialPos = testPage.getRadiusPosition();
		testPage.moveCircle(dX, dY);
		finalPos = testPage.getRadiusPosition();
		assertEquals(initialPos[0] + dX, finalPos[0]);
		assertEquals(initialPos[1] + dY, finalPos[1]);
	}

	@AfterClass
	public static void tearDown() throws Exception{
		testPage.closePage();
	}
}
