package gs.practiceCode;

/**
 * Implement function that takes as input an un-encoded potion and returns the
 * minimum number of characters required to encode As an example, consider the
 * following Un-encoded string: A, B, A, B, C, A, B, A, B, C, E Encoded string
 * using only 6 characters: A,B,*,C,*,E
 * <p>
 * Here * means repeat from beginning
 * <p>
 * ABCABCABCABC becomes ABC** ABCABCABC should be ABC*ABC
 */
public class Solution {

	public static void main(String[] args) {
		encodeString2("ABCABCABCABC");//5
		encodeString2("ABCABCABC"); //7
		encodeString2("AAAAAA"); //4
		encodeString2("AAAABBBB");//7
		encodeString2("ABABCABABCD");//6
		encodeString2("ABCABCE"); // output should be 5
		encodeString2("ABCDABCE"); // output should be 8
		encodeString2("ABABCABABCE");//6
		System.out.println("---------------");
		//minimalSteps("ABCABCABCABC");//5
		//minimalSteps("ABCABCABC"); //7
		//minimalSteps("AAAAAA"); //4
		//minimalSteps("AAAABBBB");//7
		//minimalSteps("ABABCABABCD");//6
		minimalSteps("ABCABCE"); // output should be 5
		//minimalSteps("ABCDABCE"); // output should be 8
		//minimalSteps("ABABCABABCE");//6

	}

	// looks fine except assumption that repeat char starts from index 0
	static void encodeString2(final String origString) {
		String encodedString = origString; // looping will be done on 'origString' and 'encodedString' will keep on
											// changing with * replacement.
		int currentIndex = 1;
		int currentEndIndex = 0;
		while (currentIndex < origString.length() - 1) { // Iterate entire string by each char
			String replaceKey = origString.substring(0, currentIndex + 1); // Starting from 2nd char, make a string
																			// which need to looked up for repetition
			currentEndIndex = 2 * currentIndex + 1; // this is end index of repeat string
			if (currentEndIndex > origString.length()) { // save from ArrayIndexOutOfBound
				break;
			}

			// below 'temp' is possible repeat string, starts from next element after
			// currentIndex. EndIndex +1 done as substring() excludes element at endIndex.
			String temp = origString.substring(currentIndex + 1, currentEndIndex + 1);
			if (!encodedString.contains("*") && temp.equalsIgnoreCase(replaceKey)) { // for very 1st occurrence, we need
																						// to replace 2nd occurrence of
																						// string
				encodedString = encodedString.replaceFirst(replaceKey + temp, replaceKey + "*");
				currentIndex = currentEndIndex; // Jump currentIndex till end of repeat string, no need to reach there
												// doing +1
			} else if (temp.equalsIgnoreCase(replaceKey)) { // Subsequent match cases
				encodedString = encodedString.replaceFirst(replaceKey, "*");
				currentIndex = currentEndIndex;
			} else { // If match didn't happen, keep on trying with new keys ending with currentIndex
						// (begin index remains 0)
				currentIndex++;
			}

		}
		System.out.println("Found encoded string :: " + encodedString);

	}
	
	private static Integer minimalSteps(String ingredients) {
		int n = ingredients.length();
		if (n == 0) {
			return 0;
		}

		Integer dp[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);

			// If the string can be replicated, we need to update at (2*i + 1) , because it is repeared, else keep adding elements
			if (2 * i + 1 < n && ingredients.substring(0, i + 1).equals(ingredients.substring(i + 1, 2 * i + 2))) {
				dp[2 * i + 1] = dp[i] + 1;
			}
			/*for(int x=0;x<n;x++)
				System.out.print(dp[x]+" ");
			System.out.println();*/
		}
		//System.out.println(dp[n-1]);
		return dp[n - 1];
	}

}
