package main.com.zillow.exercise;

public class IntConverter {
	private static final String THREE_WORD = "Zil";
	private static final String FIVE_WORD = "low";
	private static final String THREE_FIVE_WORD = "Zillow";
	public static String convert(int i) throws IllegalArgumentException{
		if(i<=0 || i>100) throw new IllegalArgumentException("Input range must be 1 to 100");
		if(i%3==0&&i%5==0)return THREE_FIVE_WORD;
		else if(i%3==0)return THREE_WORD;
		else if(i%5==0)return FIVE_WORD;
		return String.valueOf(i);
	}
}
