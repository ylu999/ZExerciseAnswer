package main.com.zillow.exercise;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TextStatistics {
	private char target;
	private InputStream inputStream;
	private int characterCount = 0;
	private int lineCount = 0;
	private boolean calculated = false;
	public TextStatistics(InputStream inputStream, char target) {
		this.inputStream = inputStream;
		this.target = target;
	}

	public void calculate() throws IOException {
		if(calculated)return;
		BufferedInputStream stream = new BufferedInputStream(inputStream);
		int temp = -1;
		boolean newLine = true;
		while ((temp = stream.read()) != -1) {
			if ( temp == Character.toLowerCase(target) || temp == Character.toUpperCase(target))	{
				characterCount++;
				if(newLine){
					lineCount++;
					newLine = false;
				}
			}
			if (temp == '\n') newLine = true;
		}
		calculated = true;
	}

	public char getTarget() {
		return target;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public int getCharacterCount() {
		return characterCount;
	}

	public int getLineCount() {
		return lineCount;
	}
}