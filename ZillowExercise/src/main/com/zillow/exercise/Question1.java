package main.com.zillow.exercise;
/*
 * 
Java 
Write a program that prints the numbers from 1 to 100. 
But for multiples of three print “Zil” instead of the number and for the multiples of five print “low”. 
For numbers which are multiples of both three and five print “Zillow”. 
 */
public class Question1 {
	public static void main(String[] args){
		new Question1().answer();
	}
	public void answer(){
		for(int i=1;i<=100;i++){
			System.out.println(IntConverter.convert(i));
		}
	}
}
