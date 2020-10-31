package com.revature.eval.java.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		//convert phrase to char array;
		
		char[] charPhrase = phrase.toCharArray();
		//detect how many spaces (n) are in phrase.
		int n = 0;
		for (int i = 0; i < phrase.length(); i++) {
			
			if ((charPhrase[i]>='a' && charPhrase[i]<='z') || (charPhrase[i]>='A' && charPhrase[i]<='Z')) {
				n += 0;
			}
			else {
				if (charPhrase[i + 1] != ' ') {
					n++;
				}
			}
		}
		
		//create new char array that has n + 1 number of characters 
		char[] acro = new char[n + 1];
		
		//pull the first letter from each word of the phrase and add it to the new array
		//use iterator k for acronym array
		int k = 0;
		//do first word manually
		acro[k] = charPhrase[0];
		k++;
		//use iterator k for acronym array
		for (int i = 0; i < phrase.length(); i++) {
			if ((charPhrase[i]>='a' && charPhrase[i]<='z') || (charPhrase[i]>='A' && charPhrase[i]<='Z')) {
				
			}
			else {
				if (charPhrase[i + 1] != ' ') {
				acro[k] = charPhrase[i + 1];
				k++;
			}
		}
		}
		//convert char array to string and make sure new string is all upper case
		String acroString = new String(acro);
		acroString = acroString.toUpperCase();
		
		//return new string
		return acroString;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// all 3 sides same length
			if (this.sideOne == this.sideTwo && this.sideOne == this.sideThree) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			if (this.sideOne == this.sideTwo || this.sideOne == this.sideThree || this.sideTwo == this.sideThree) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			// no sides are the same length
			if (this.sideOne != this.sideTwo && this.sideOne != this.sideThree && this.sideTwo != this.sideThree ) {
				return true;
			}
			return false;
		}
	}


	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		//convert string to all uppercase 
		string = string.toUpperCase();
		//use for loop to add up scrabble scores
		int score = 0;
		for (int i = 0; i < string.length(); i++) {
			char tile = string.charAt(i);
			if (tile == 'A'|| tile == 'E' || tile == 'I'|| tile == 'O' || tile ==  'U'
					|| tile == 'L' || tile == 'N' || tile == 'R' || tile == 'S' || tile == 'T') {
							score+= 1;
					}
			if (tile == 'D' || tile == 'G') {
				score += 2;

			}
			if (tile == 'B' || tile == 'C' || tile == 'M' || tile == 'P') {
				score += 3;
			}
			if (tile == 'F' || tile == 'H' || tile == 'V' || tile == 'W' || tile == 'Y') {
				score += 4;
			}
			if (tile == 'K') {
				score += 5;
			}
			if (tile == 'J' || tile == 'X') {
				score += 8;
			}
			if (tile == 'Z') {
				score += 10;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// find out how many numbers are in the string and add them to an invalid number
		char[] invalid = new char[11];
		
		char[] tester = string.toCharArray();
		
		for (int i = 0; i < string.length(); i++) {
			if (java.lang.Character.isAlphabetic(tester[i])) {
				throw new IllegalArgumentException("Not all digits");
			}
		}
		
		
		string = string.replaceAll("\\p{Punct}", "");
		string = string.replaceAll(" ", "");
		
		if (string.length() > 11) {
			throw new IllegalArgumentException("Too many digits");
		}
		int count = 0;
		int j = 0;
		for (int i = 0; i < string.length(); i++) {
			char temp = string.charAt(i);
			if (java.lang.Character.isDigit(temp) ) {
				count++;
				invalid[j] = temp;
				j++;
			}
		}
		//create new char array 
		char[] newNumber = new char[10];
		
		//determine if country code needs to be removed
		int transfer = 0;
		if (count > 10) {
			transfer++;
		}
		//transfer invalid number to new number
		for (int i = 0; i < 10; i++) {
			newNumber[i] = invalid[transfer];
			transfer++;
		}
		
		
		return new String(newNumber);
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		//create a hashmap to store the words and their occurrences
		Map<String, Integer> wordCount = new HashMap<>();
		
		//split the words 
		String[] words = string.split("\\s+");
		
		//count the words using a loop
		for (String str : words) {
		
			//add word to loop, set count to one if not already in hashmap
			if (wordCount.get(str) == null) {
				wordCount.put(str, 1);
			}
		
			else {
				wordCount.put(str,(wordCount.get(str) + 1));
			}
		
		}
		
		
		return wordCount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			return sortedList.indexOf(t);
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		//created new array with a size + 2 of the string
		
		String[] words = string.split("\\s+");
		
		String totalPhrase = new String();
		
		
		int spaceCount = -1;
		int extraLetterCount = 0;
		
		for (String str : words) {
			spaceCount++;
		}
		
		
		//count the words using a loop
		for (String str : words) {
		char[] arr =  str.toCharArray();
		
		//determine if the first letter is a consonant or a vowel
		//use a for loop to transfer the string to the new array
		char letter = arr[0];
		char firstLetter;
		char[] vowelPig = new char[string.length() + 2];
		if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
			for (int i = 0; i < string.length(); i++) {
				vowelPig[i] = arr[i];
			}
			vowelPig[string.length()] = 'a';
			extraLetterCount++;
			vowelPig[string.length() + 1] = 'y';
			extraLetterCount++;
			
			String newString = new String(vowelPig);
		
			totalPhrase += newString;
		}
		else {
			int count = 0;
			if (letter == 'q') {
			while (letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o') {
				count++;
				letter = arr[count];
			}
			}
			else {
				while (letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o' && letter != 'u') {
					count++;
					letter = arr[count];
				
			}
		char[] consonants = new char[count];
		for (int i = 0; i < count; i++) {
			consonants[i] = arr[i];
		}
		char[] consPig = new char[string.length() + 2];
			firstLetter = arr[0];
			int j = 0;
			for (int i = (count); i < string.length(); i++) {
				consPig[j] = arr[i];
				j++;
			}
			for (int i = 0; i < count; i++) {
			consPig[(string.length() - count) + i] = consonants[i];
		}
			
			consPig[string.length()] = 'a';
			extraLetterCount++;
			consPig[string.length() + 1] = 'y';
			extraLetterCount++;

		
		//convert back to string and add "a" "y" to the end
	
		String newString = new String(consPig);
		totalPhrase += newString;
			}
		}
		}
		char[] arr21 = string.toCharArray();
		char[] arrTotal = totalPhrase.toCharArray();
		char[] finalPhrase = new char[string.length() + extraLetterCount];
		
		int j = 0;
		int p = 0;
		for (int i = 0; i < string.length() + extraLetterCount; i++ ) {
			if (arr21[j] == ' ') {
				finalPhrase[i + 2] = ' ';
				j += 2;
			}
			else {
				finalPhrase[i] = arrTotal[p];
				p++;
			}
		}
		String afterAll = new String(finalPhrase);
		
		return afterAll;

	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		//find out how many digits are in the number
		int copy1 = input;
		int numDigits = 0;
		while (copy1 != 0) {
			copy1 /= 10;
			numDigits++;
		}
		//add the sum of the numbers to the power of the number of digits
		int copy2 = input;
		int sum = 0;
		for (int i = 0; i < numDigits; i++) {
			sum += Math.pow((copy2 % 10), numDigits);
			copy2 /= 10;
		}
		//determine if the sum is the same as the number
		if (sum == input) {
			
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {

		List<Long> primeFactors = new ArrayList<Long>();
	
			
			for (long num = 2; num <= l; num++) {
		            while(l % num == 0)  {
		            	if (num > 1) {
		               primeFactors.add(num);
		            }
		           	 l = l / num;
		           }

		        
			}
			return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			char[] arr = string.toCharArray();
			for (int i = 0; i < string.length(); i++) {
			char c = arr[i];
			char result = arr[i];
			//checks to make sure the char is a letter
			if (java.lang.Character.isAlphabetic(c)) {
			int alphaNum = 26; 
		    int n = (key % alphaNum);
		    result = (char) (n + c);
		    // If character input is uppercase
		    if (java.lang.Character.isUpperCase(c)) { 
		    if (result < 'A') {
		    	// adds remainder to alphabet
		    	result = (char) (result + alphaNum);
		    }
		        if (result > 'Z') {
		        	// subtracts remainder from alphabet
		            result = (char) (result - alphaNum); 
		      }
		    }
		    
		    //If character input is lowercase
		    if (java.lang.Character.isLowerCase(c)) { // If character input is lowercase
	             if (result < 'a') {
	                   result = (char) (result + alphaNum);
	               }
	           if (result > 'z') {
	           result = (char) (result - alphaNum);

	                }
		 
		}
   }
			
			//if the char is not a letter, is added to the array unchanged
			//adds new char to array
	    	arr[i] = result;
	}
			String rotated = new String(arr);
			return rotated;
	}
	
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		if (i == 0) {
			throw new IllegalArgumentException("Cannot enter zero");
		}
		
		List<Integer> primeFactors = new ArrayList<Integer>();
		int l = i;
		
		for (int num = 2; num <= i; num++) {
	            while(l % num == 0)  {
	            	if (num > 1) {
	               primeFactors.add(num);
	            }
	           	 l = l / num;
	           }

	        
		}
	int nth = primeFactors.get(i);
	return nth;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
		
			string = string.toLowerCase();
			string = string.replaceAll(" ", "");
			string = string.replaceAll("\\p{Punct}", "");
			char[] arr = string.toCharArray();
			char[] newMessage = new char[string.length() + (string.length() / 5)];
			for (int i = 0; i < string.length(); i++) {
				if (java.lang.Character.isAlphabetic(arr[i])){
				char start = 'a';
				char end = 'z';
				int diff = (int) start - arr[i];
				char newChar = (char) (end + diff);
				arr[i] = newChar;
				}
				}
			
			newMessage[0] = arr[0];
			int accountable = 5;
			int otherCount = 1;
			int j = 1;
			for (int i = 1; i < string.length() + (string.length() / 5); i++) {
				if (i == accountable) {
					newMessage[i] = ' ';
					accountable = (accountable * 2) + otherCount;
					otherCount++;
				}
				else {
					newMessage[i] = arr[j];
					j++;
				}
			}
			
			String newString = new String(newMessage);
			return newString;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			string = string.replaceAll(" ", "");
			char[] arr = string.toCharArray();
			char[] decoded = new char[string.length()];
			for (int i = 0; i < string.length(); i++) {
				if (java.lang.Character.isAlphabetic(arr[i])){
				char start = 'a';
				char end = 'z';
				int diff = (int) start - arr[i];
				char newChar = (char) (end + diff);
				decoded[i] = newChar;
				}
				}
			
			String newString = new String(decoded);
			return newString;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		
		string = string.replaceAll("\\p{Punct}", "");
		
		char[] charArr = string.toCharArray();
		
		int sum = 0;
		
		int j = 10;
		for (int i = 0; i < string.length() - 1; i++) {
			int p = (int)charArr[i];
			sum += (p * j);
			j--;
		}
		
		if (java.lang.Character.isDigit(charArr[string.length() - 1])) {
			sum += (charArr[string.length() - 1]);
			if (sum % 11 == 0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		if (java.lang.Character.isAlphabetic(charArr[string.length() - 1])) {
			if (charArr[string.length() - 1] == 'X') {
				sum += 10;
				if (sum % 11 == 0) {
					return true;
				}
				else {
					return false;
				}
			}
		}
	
		
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		char[] arr = string.toCharArray();
		int count = 0;
		//convert string to upper case for simplicity
		//and loop through to check if each letter is in the string
		for (char a = 'A'; java.lang.Character.isAlphabetic(a); a++ ) {
			for (int i = 0; i < string.length(); i++) {
				if (java.lang.Character.toUpperCase(arr[i]) == a) {
					count++;
					break;
				}
			}
		}
		if (count < 26) {
			return false;
		}
		else {
		return true;
	}
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		if (!(given instanceof LocalDateTime)) {
			LocalDate newLocal = (LocalDate) given;
			LocalDateTime later = LocalDateTime.of(newLocal.getYear(), newLocal.getMonth(),newLocal.getDayOfMonth(), 0 , 0 , 0 );
			return (Temporal) later.plusSeconds(1000000000);
		}
		
		else  {
		Temporal later = given.plus(1000000000, ChronoUnit.SECONDS);
		return later;
		}
		
		
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
	//create a hashmap to store the words and their occurrences
	
		Map<Integer, Integer> multiples = new HashMap<>();
			
		int sum = 0;
		for (i = i--; i > 0; i--) {
			for (int n : set) {
				if ((i % n) == 0) {
					if (multiples.get(i) == null) {
						multiples.put(i, n);
					}
					else {
						multiples.put(i, multiples.get(i) + 1);
					}
				
			}
			}
		}
		for (Map.Entry<Integer, Integer> entry : multiples.entrySet()) {
			sum += entry.getKey();
  
        }
		
	
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		//remove all spaces from the string
		string = string.replaceAll("\\s+", "");
		char[] arr = string.toCharArray();
		int[] intArr = new int[string.length()];
		 for (int i = string.length() - 1; i >= 0; i--) {
			 if ((string.length() - i) % 2 == 0) {
				 int q = Character.getNumericValue(arr[i]);
				 q *= 2;
				 if (q > 9) {
					 q -= 9;
				 }
				 intArr[i] = q;
			 }
			 else {
				 intArr[i] = Character.getNumericValue(arr[i]);
			 }
	
			
		}
		int sum = 0;
		for (int i = 0; i < string.length(); i++) {
			sum += intArr[i];
		}
		
		if (sum % 10 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(string);
		
		while (m.find()) {
			String q = m.group();
		}
		return 0;
	}

}
