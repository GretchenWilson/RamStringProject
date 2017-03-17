
/**
 * This is an interface for a simple class that represents a string, defined
 * as a sequence of characters. 
 *
 */
public interface WackyStringInterface {

	/**
	 * Sets the value of the current string.
	 */
	void setWackyString(String string);

	String getWackyString();

	String getEvenCharacters();

	String getOddCharacters();

	int countNonDigits();

  void ramifyString();

	void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition)
			throws MyIndexOutOfBoundsException, IllegalArgumentException;
}
