package com.revature.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

public class JavaCollectionSolutions implements JavaCollection {
	
	private static final Logger LOGGER = Logger.getLogger(JavaCollectionSolutions.class);
	
	@Override
	//Returns the list of digits that make up the given int
	public List<Integer> digits(int n) throws IllegalArgumentException {
		//make sure n is not less than 1
		try {
			if(n<=0) {
				throw new IllegalArgumentException();
			}
		}catch (IllegalArgumentException iae) {
			LOGGER.error("Cannot get the digits of 0 or a negative number!");
		}
		
		//first pull each digit out using its decimal place (tens, hundreds, thousands...)
		List<Integer> digits = new LinkedList<Integer>();
		int tens = 10;
		while(n!=0) {
			digits.add(n%tens);
			n -= (n%tens);
			tens *= 10;
		}
		
		//then remove the extra zeros following each digit (3000 -> 3)
		tens /= 100;
		List<Integer> digitsOrdered = new LinkedList<Integer>();
		for(int i = (digits.size()-1); i>=0; i--) {
			digitsOrdered.add(digits.get(i)/tens);
			tens /= 10;
		}
		
		//finally return the list
		return digitsOrdered;
	}

	@Override
	public Set<?> sort(Object[] array) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		/**
		 * 2. Sort a given array using Comparable or Comparator.
		 * 
		 * Remember, you can use your own POJO on the implementation.
		 * 
		 * @return A sorted collection based on the input array.
		 * 
		 * @throws IllegalArgumentException if the array is null.
		**/
		return null;
	}

	@Override
	//Returns whether or not a given string has balanced brackets
	public boolean balancedBrackets(String brackets) throws IllegalArgumentException {
		//make sure they didn't send an empty or null string
		try {
			if((brackets==null)||(brackets.isEmpty())){
				throw new IllegalArgumentException();
			}
		}catch (IllegalArgumentException iae) {
			LOGGER.error("Cannot check an empty string!");
		}
		
		/*
		 * Useful LinkedList methods:
		 * getFirst()
		 * getLast()
		 * removeFirst()
		 * removeLast()
		 * addFirst()
		 * addLast()
		 */
		
		//converts the sting into a character array so brackets are easier to grab individually
		char[] stringArr = brackets.toCharArray();
		//an uneven number of brackets is automatically unbalanced.
		if(stringArr.length%2!=0) {
			return false;
		}
		
		//we use a LinkedList to keep track of the order of brackets
		LinkedList<Character> bracketsTracker = new LinkedList<Character>();
		 
		
		for(char c : stringArr) {
			//first check if the character is an open bracket
			if((c=='(')||(c=='[')||(c=='{')) {
				//if it is, add it to the beginning of the LinkedList
				bracketsTracker.addFirst(c);
			} 
			//else, if it's a closed bracket...
			else {
				//...remove the most recent open bracket from the LinkedList
				//		and compare it to the current closed bracket, c.
				
				char open = bracketsTracker.removeFirst();
				
				//compare the open and close brackets
				switch(open) {
					case '(':
						if(c!=')') {
							return false;
						}
						break;
					case '[':
						if(c!=']') {
							return false;
						}
						break;
					case '{':
						if(c!='}') {
							return false;
						}
						break;
		}	}	}
		
		//finally, check for any open brackets left in the LinkedList, making the given string unbalanced.
		if(bracketsTracker.size()!=0) {
			return false;
		}
		//if it passes all the tests, then it's balanced!
		return true;
	}

	@Override
	public boolean isPalindrome(int n) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		/**
		 * 4. Check if a number is palindrome using collections.
		 * 
		 * Hint: Use your digits solution.
		 * 
		 * @throws IllegalArgumentException if n is less than 0.
		 */
		
		
		return false;
	}

	@Override
	public Map<Character, Integer> countCharacters(String string) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		/**
		 * 5. Count how many times each character existing in a String repeats using
		 * a map as the storing structure.
		 * 
		 * Hint: Remember, the key part of a map is a Set.
		 * 
		 * @return The Map containing each character and how many times it repeats.
		 * 
		 * @throws IllegalArgumentException if the string is null
		 */
		return null;
	}

	public static void main(String[] args) {
		JavaCollectionSolutions jcs = new JavaCollectionSolutions();
		
		LOGGER.info(jcs.digits(153)); // = [1, 5, 3]
		LOGGER.info(jcs.digits(32767)); // = [3, 2, 7, 6, 7]
		
		LOGGER.info(jcs.balancedBrackets("({[]})")); //= true
		LOGGER.info(jcs.balancedBrackets("([)]")); //= false
	}

}
