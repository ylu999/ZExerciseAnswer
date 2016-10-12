package test.com.zillow.exercise;

import static org.junit.Assert.assertEquals;
import main.com.zillow.exercise.IntConverter;

import org.junit.Test;

public class IntConverterTest {

	@Test(expected=IllegalArgumentException.class)
	public void negativeExpectedThrowIllegalArgumentException() {
		IntConverter.convert(-1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void ZeroExpectedThrowIllegalArgumentException() {
		IntConverter.convert(0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void outRangeExpectedThrowIllegalArgumentException() {
		IntConverter.convert(101);
	}
	@Test
	public void OneExpectedOne() {
		assertEquals("1",IntConverter.convert(1));
	}
	@Test
	public void TwoExpectedTwo() {
		assertEquals("2",IntConverter.convert(2));
	}
	@Test
	public void ThreeExpectedZil() {
		assertEquals("Zil",IntConverter.convert(3));
	}
	@Test
	public void FourExpectedFour() {
		assertEquals("4",IntConverter.convert(4));
	}
	@Test
	public void NineExpectedZil() {
		assertEquals("Zil",IntConverter.convert(9));
	}
	@Test
	public void FiveExpectedLow() {
		assertEquals("low",IntConverter.convert(5));
	}
	@Test
	public void FifteenExpectedZillow() {
		assertEquals("Zillow",IntConverter.convert(15));
	}

}
