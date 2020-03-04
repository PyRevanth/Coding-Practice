package FTD;

public class StringCompressAndExpansion {
	/*
	 * Given a string that includes alphanumeric characters ('a3b4z') return the
	 * expansion of that string: The numeric values represent the occurrence of each
	 * letter preceding that numeric value. There should be no numeric characters in
	 * the final string. Empty strings should return an empty string.
	 * 
	 * The first occurrence of a numeric value should be the number of times each
	 * character behind it is repeated, until the next numeric value appears. *
	 * 
	 * String Expansion Input a3b4z Output: aaabbbbz
	 *
	 * String Compression Input aaabbbbz Output: a3b4z
	 */

	public static void main(String[] args) {
		String str = "aaabbbccccc";
		String str1 = "a3b3c5u";
		stringCompress(str);
		StringExpansion(str1);
	}

	public static void stringCompress(String str) {
		int length = str.length();
		// create stringBuilder class
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 0; i < length; i++) {
			if (i == length - 1) {
				sb.append(str.charAt(i) + "" + count);
				break;
			} else {
				if (str.charAt(i) == str.charAt(i + 1)) {
					count++;
				} else {
					sb.append(str.charAt(i) + "" + count);
					count = 1;
				}

			}
		}
		System.out.println("String Compression of " + str + " : " + sb.toString());
	}

	public static void StringExpansion(String str) {
		StringBuilder sb = new StringBuilder();
		int repeat = 0;
		for (Character c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				repeat = (repeat * 10) + Character.getNumericValue(c);
			} else if (repeat > 0) {
				while (repeat > 0) {
					sb.append(c);
					repeat--;
				}
			} else {
				sb.append(c);

			}
		}
		System.out.println("String Expansion of " + str + " : " + sb.toString());
	}

}
