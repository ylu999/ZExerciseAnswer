package main.com.zillow.exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
 * 
 Java 
 Write a program that prints the following statistics about specific characters passed to the function for the given block of text 

 1. The number of times a character occurs, upper or lower case 
 2. The number of lines a character occurs on 

 Text: 
 Banksy slow-carb vegan, chillwave cardigan ennui flannel sriracha cliche Odd Future. 
 Direct trade selvage viral food truck readymade chia. Sartorial YOLO forage Carles 
 Echo Park Williamsburg. Post-ironic Banksy wayfarers chillwave art party, flexitarian 
 kogi Neutra raw denim wolf trust fund High Life. Chambray mixtape food truck tattooed, 
 Portland occupy synth freegan. Hella try-hard four loko, pour-over asymmetrical before 
 they sold out disrupt distillery semiotics tousled. DIY raw denim Shoreditch wayfarers, 
 normcore farm-to-table literally sustainable whatever tattooed cred Odd Future selvage 
 try-hard. 
 Canada smile on your face, even though your heart is frowning baby, baby, baby, oh. 
 I'ma make you shine bright like you're laying in the snow, burr I like Sour Patch Kids 
 baby, baby, baby, oh. What you got, a billion could've never bought I'ma make you shine 
 bright like you're laying in the snow, burr no one can stop me. We don't need no wings to 
 fly what you got, a billion could've never bought swag. And all the haters I swear they 
 look so small from up here got your girlfriend at my crib watching Netflix baby know for 
 sho', I'll never let you go. I like Sour Patch Kids worst birthday ever I'm in pieces, so 
 come fix me. I could be your Buzz Lightyear fly across the globe I could be your Buzz 
 Lightyear fly across the globe if I was your boyfriend, I'd never let you go. But something 
 would be nothing baby, baby, baby, oh swag. 
 */
public class Question2 {
	private static final String INPUT_FILE_NAME = "Question2.input";

	public static void main(String[] args) throws IOException {
		new Question2().answer(INPUT_FILE_NAME,' ');
		new Question2().answer(INPUT_FILE_NAME,'\r');
		new Question2().answer(INPUT_FILE_NAME,'\n');
		new Question2().answer(INPUT_FILE_NAME,'a');
		new Question2().answer(INPUT_FILE_NAME,'b');
		new Question2().answer(INPUT_FILE_NAME,'c');
		new Question2().answer(INPUT_FILE_NAME,'d');
		new Question2().answer(INPUT_FILE_NAME,'\'');
	}

	public void answer(String inputFileName, char target) throws IOException{
		TextStatistics textStatistics = new TextStatistics(getInputStream(inputFileName), target);
		textStatistics.calculate();
		System.out.println("1. Character occurs "+textStatistics.getCharacterCount()+" times");
		System.out.println("2. Character occurs on "+textStatistics.getLineCount()+" lines");
	}

	private static InputStream getInputStream(String inputFileName)	throws FileNotFoundException {
		File file = new File(inputFileName);
	    InputStream inputStream = new FileInputStream(file);
		return inputStream;
	}
}


