package test.com.zillow.exercise;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import main.com.zillow.exercise.TextStatistics;

import org.junit.Before;
import org.junit.Test;

public class TextStatisticsTest {
	@Before
	public void setup(){
		
	}
	@Test
	public void emptyStringExpectZero() throws IOException {
		InputStream in = new ByteArrayInputStream("".getBytes());
		TextStatistics ts = new TextStatistics(in, ' ');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 0);
		assertEquals(ts.getLineCount(),0);
	}
	@Test
	public void spaceCharExpectThree() throws IOException {
		InputStream in = new ByteArrayInputStream("   ".getBytes());
		TextStatistics ts = new TextStatistics(in, ' ');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),1);
	}
	@Test
	public void lineBreakRCharExpectThree() throws IOException {
		InputStream in = new ByteArrayInputStream("aa\r\naa\r\naa\r\naa".getBytes());
		TextStatistics ts = new TextStatistics(in, '\r');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),3);
	}
	@Test
	public void lineBreakNCharExpectThree() throws IOException {
		InputStream in = new ByteArrayInputStream("aa\r\naa\r\naa\r\naa".getBytes());
		TextStatistics ts = new TextStatistics(in, '\n');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),3);
	}
	@Test
	public void lineBreakNCharExpectFour() throws IOException {
		InputStream in = new ByteArrayInputStream("aa\r\naa\r\naa\r\naa\n".getBytes());
		TextStatistics ts = new TextStatistics(in, '\n');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 4);
		assertEquals(ts.getLineCount(),4);
	}
	@Test
	public void lineBreakNCharWithContinuesRNLineBreakExpectFour() throws IOException {
		InputStream in = new ByteArrayInputStream("\r\n\r\n\r\n\n".getBytes());
		TextStatistics ts = new TextStatistics(in, '\n');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 4);
		assertEquals(ts.getLineCount(),4);
	}
	@Test
	public void lineBreakNCharWithContinuesNRLineBreakExpectFour() throws IOException {
		InputStream in = new ByteArrayInputStream("\n\r\n\r\n\r\n".getBytes());
		TextStatistics ts = new TextStatistics(in, '\n');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 4);
		assertEquals(ts.getLineCount(),4);
	}
	@Test
	public void regularCharExpectEight() throws IOException {
		InputStream in = new ByteArrayInputStream("aa\r\naa\r\naa\r\naa\n".getBytes());
		TextStatistics ts = new TextStatistics(in, 'a');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 8);
		assertEquals(ts.getLineCount(),4);
	}
	@Test
	public void runCalculateTwiceExpectTheSame() throws IOException{
		InputStream in = new ByteArrayInputStream("   ".getBytes());
		TextStatistics ts = new TextStatistics(in, ' ');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),1);
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),1);
	}
}
