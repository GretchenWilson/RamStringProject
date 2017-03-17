//********************************************************************************
// Gretchen Wilson
// CMSC 256 Fall 2016
// RamString.java
//
// RamString creates a string object that can be counted and manipulated.
//********************************************************************************

import java.io.*;
import java.util.*;


public class RamString implements WackyStringInterface {
	private String currentString;
	
	@Override
	public void setWackyString(String string) {
		// Sets class parameter to given method string parameter if given parameter is not null.
		currentString = string;	
	}

	@Override
	public String getWackyString() {
		// TODO Auto-generated method stub
		return currentString;
	}

	@Override
	public String getEvenCharacters() {
		
		// Returns a string of the even characters in the currentString. 
		//If the string is null, it returns null
		
		if (currentString == null) {
			return null;
		}
		String evenString = "";
		for (int i=1; i<currentString.length(); i=i+2) {
			evenString += currentString.charAt(i);
		}
		return evenString;
	}

	@Override
	public String getOddCharacters() {
		
		// Returns a string with the odd characters in the currentString 
		// If the current string is null, it will return null
		
		if (currentString == null) {
			return null;
		}
		
		String oddString = "";
		for (int i=0; i<currentString.length(); i=i+2) {
			oddString += currentString.charAt(i);
		}
		return oddString;
	}

	@Override
	public int countNonDigits() {
		
		// Returns the number of non-digits in the currentString
		//// If the current string is null, it will return 0
		
		if (currentString == null) {
			return 0;
		}	
		int count = 0;
		Scanner scanString = new Scanner(currentString);
		scanString.useDelimiter("");
		while (scanString.hasNext()) {
			char ch = scanString.next().charAt(0);
			if (!Character.isDigit(ch)) {
				count ++;
			}
		}
		return count;
	}

	@Override
	public void ramifyString() {
		
		//Replace all occurence of a single zero (0) with the string "Rams"
	    //and all occurence of a double zero (00) with the string "VCU"
		
		String ramString = "";
		int zeroCount = 0;
		if (currentString != null) {
		for (int i=0; i<currentString.length(); i=i+1) {
			
			char ch = currentString.charAt(i);
			char after;
			char after2;
			
			
			if (ch == '0') {
				
				zeroCount = 0;
				int forward = 1;
				while (i+forward <currentString.length()) {	
					char check = currentString.charAt(i+forward);
					if (check == '0') {
						zeroCount++;
						forward++;
					}
					else{
						break;
					}
				}
				if (zeroCount ==0) {
					currentString = currentString.substring(0,i) + "RAM" + currentString.substring(i+1, currentString.length());
				}
				else if (zeroCount==1) {			
					currentString = currentString.substring(0,i) + "VCU" + currentString.substring(i+2, currentString.length());
					i++;
				}
				else {
					i = i+zeroCount;
				}
			}
		}
		}
	}
	
	@Override
	public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition)
			throws MyIndexOutOfBoundsException, IllegalArgumentException {
		
		//Replace the _individual_ digits in the current string, between
		//startPosition and endPosition (included), with the corresponding
		//Roman numeral symbol(s). The first character in the string is
		//considered to be in Position 1
		
		if (currentString != null && currentString.length() > 0){
		if (startPosition > currentString.length() || startPosition < 1 || endPosition > currentString.length() || endPosition < 1){
			throw new MyIndexOutOfBoundsException("\t**For method convertDigitsToRomanNumeralsInSubstring, the start and end position must be in bounds with the first character as Position 1.**");
		}
		if (endPosition < startPosition) {
			throw new IllegalArgumentException("\t**For method convertDigitsToRomanNumeralsInSubstring, given start position must come before the end position.**");
			}
		
		String[][] romanList = {{"1","I"}, {"2", "II"}, {"3", "III"}, {"4", "IV"}, {"5", "V"}, {"6", "VI"}, {"7", "VII"}, {"8", "VIII"}, {"9", "IX"}};
		String testString = currentString.substring(startPosition-1, endPosition);
		//System.out.println(testString);
		String reconstructString = "";
		
		for (int i=0; i<testString.length(); i=i+1) {
			String character = testString.substring(i,i+1);
			//System.out.println(character);
			int step = 0;
			for (String[] roman : romanList) {
				if (character.equals(roman[0])) {
					//System.out.println("match");
					step = character.length() - roman[1].length();
					character = roman[1];	
				}
			}
			reconstructString += character;
		}
		String newString = 	currentString.substring(0, startPosition-1) + reconstructString + currentString.substring(endPosition, currentString.length());
		currentString = newString;
		//System.out.println(reconstructString);
		}
	}	
}
