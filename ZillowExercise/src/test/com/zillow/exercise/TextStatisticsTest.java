import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import main.com.zillow.exercise.TextStatistics;

public class TextStatisticsTest {
	private TextStatistics ts;
	private InputStream in;
	@Before
	public void setup(){
		
	}
	@Test
	public void emptyStringExpectZero() throws IOException {
		in = new ByteArrayInputStream("".getBytes());
		ts = new TextStatistics(in, ' ');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 0);
		assertEquals(ts.getLineCount(),0);
	}
	@Test
	public void spaceCharExpectThree() throws IOException {
		in = new ByteArrayInputStream("   ".getBytes());
		ts = new TextStatistics(in, ' ');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),1);
	}
	@Test
	public void lineBreakRCharExpectThree() throws IOException {
		in = new ByteArrayInputStream("aa\r\naa\r\naa\r\naa".getBytes());
		ts = new TextStatistics(in, '\r');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),3);
	}
	@Test
	public void lineBreakNCharExpectThree() throws IOException {
		in = new ByteArrayInputStream("aa\r\naa\r\naa\r\naa".getBytes());
		ts = new TextStatistics(in, '\n');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),3);
	}
	@Test
	public void lineBreakNCharExpectFour() throws IOException {
		in = new ByteArrayInputStream("aa\r\naa\r\naa\r\naa\n".getBytes());
		ts = new TextStatistics(in, '\n');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 4);
		assertEquals(ts.getLineCount(),4);
	}
	@Test
	public void lineBreakNCharWithContinuesRNLineBreakExpectFour() throws IOException {
		in = new ByteArrayInputStream("\r\n\r\n\r\n\n".getBytes());
		ts = new TextStatistics(in, '\n');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 4);
		assertEquals(ts.getLineCount(),4);
	}
	@Test
	public void lineBreakNCharWithContinuesNRLineBreakExpectFour() throws IOException {
		in = new ByteArrayInputStream("\n\r\n\r\n\r\n".getBytes());
		ts = new TextStatistics(in, '\n');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 4);
		assertEquals(ts.getLineCount(),4);
	}
	@Test
	public void regularCharExpectEight() throws IOException {
		in = new ByteArrayInputStream("aa\r\naa\r\naa\r\naa\n".getBytes());
		ts = new TextStatistics(in, 'a');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 8);
		assertEquals(ts.getLineCount(),4);
	}
	@Test
	public void runCalculateTwiceExpectTheSame() throws IOException{
		in = new ByteArrayInputStream("   ".getBytes());
		ts = new TextStatistics(in, ' ');
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),1);
		ts.calculate();
		assertEquals(ts.getCharacterCount(), 3);
		assertEquals(ts.getLineCount(),1);
	}
}
