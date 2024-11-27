/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen"));  // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcessNoSpaces(str1);
		str2 = preProcessNoSpaces(str2);

		if (str1.length() != str2.length()) {
			return false;
		}

		for (int i = 0; i < str1.length(); i++) {

			int counter1 = 0;
			int counter2 = 0;
			char currentChar1 = str1.charAt(i);

			for (int j = 0; j < str1.length(); j++)
				if (currentChar1 == str1.charAt(j)) {
					counter1++;
				}

			char cuurentChar2 = currentChar1;

			for (int j = 0; j < str2.length(); j++)
				if (cuurentChar2 == str2.charAt(j)) {
					counter2++;
				}

			if (counter1 != counter2) {
				return false;
			}
		}
		return true;
	}


	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		int lenth = str.length();
		String newStr = "";
		for (int i = 0; i < lenth; i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				newStr = newStr + (char) (str.charAt(i) + 32);
			} else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				newStr = newStr + (str.charAt(i));
			} else if (str.charAt(i) == ' ') {
				newStr = newStr + (str.charAt(i));
			}
		}
		return newStr;
	}

	public static String preProcessNoSpaces(String str) {
		int lenth = str.length();
		String newStr = "";
		for (int i = 0; i < lenth; i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				newStr = newStr + (char) (str.charAt(i) + 32);
			} else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				newStr = newStr + (str.charAt(i));
			}
		}
		return newStr;
	}



	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String stringToProcess = preProcess(str);
		String tempStr = stringToProcess;
		String newStr = "";


		while (tempStr.length() > 0) {
			int random = (int) (Math.random() * tempStr.length());
			char c = tempStr.charAt(random);

			newStr = newStr + c;

			String updatedTempStr = "";

			for (int i = 0; i < tempStr.length(); i++) {
				if (i != random) {
					updatedTempStr += tempStr.charAt (i);
				}
			}
			tempStr = updatedTempStr;
		}
		return newStr;
	}
}
