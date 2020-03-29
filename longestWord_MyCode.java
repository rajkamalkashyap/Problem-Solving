package gs;

//Given a a string of letters and a dictionary, the function longestWord should
//find the longest word or words in the dictionary that can be made from the letters
//Input: letters = "oet", dictionary = {"to","toe","toes"}
//Output: {"toe"}

import java.util.*;

class Dictionary {
	private String[] entries;

	public Dictionary(String[] entries) {
		this.entries = entries;
	}

	public boolean contains(String word) {
		return Arrays.asList(entries).contains(word);
	}
	public String[] getEntries() {
		return this.entries;
	}
}

public class longestWord_MyCode {
	public static Set<String> longestWord(String letters, Dictionary dict) {
		Set<String> result = new HashSet<String>();
		String arr[]= dict.getEntries();
		boolean[] hash = new boolean[27];
		for (int i = 0; i < letters.length(); i++)
			hash[letters.charAt(i) - 'a'] = true;
		int max_len = 0;
		ArrayList<String> ans = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			String tmp = arr[i];
			int curr_len = tmp.length();
			if (curr_len < max_len)
				continue;
			int flag = 0;
			for (int j = 0; j < tmp.length(); j++) {
				if (hash[tmp.charAt(j) - 'a'] == false) {
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				max_len = curr_len;
				ans.add(tmp);
			}
		}
		
		for (int i = 0; i < ans.size(); i++) {
			if (ans.get(i).length() == max_len) {
				//System.out.print(ans.get(i) + " ");
				result.add(ans.get(i));
			}
		}
		return result;
	}

	public static boolean pass() {
		Dictionary dict = new Dictionary(new String[] { "to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
		boolean result = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
		result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));
	    result = result && new HashSet<String>(Arrays.asList("doe","toe", "dog", "god")).equals(longestWord("oetdg", dict));
	    result = result && new HashSet<String>(Arrays.asList("book")).equals(longestWord("obokt", dict));
	    result = result && new HashSet<String>(Arrays.asList("banana")).equals(longestWord("nanabaook", dict));
	    result = result && new HashSet<String>().equals(longestWord("aeiou", dict));
	    result = result && new HashSet<String>().equals(longestWord("a", dict));
		return result;
	}

	public static void main(String[] args) {
		if (pass()) {
			System.out.println("Pass");
		} else {
			System.err.println("Fails");
		}
	}
}
