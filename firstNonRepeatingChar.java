package gs;

import java.util.HashMap;

public class firstNonRepeatingChar {

	public static void main(String[] args) {
		String s = "rajaarr";
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (hm.containsKey(c)) {
				Integer cnt = hm.get(c);
				cnt = cnt + 1;
				hm.put(c, cnt);
			} else {
				hm.put(c, 1);
			}
		}
		char ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hm.containsKey(c)) {
				int count = hm.get(c);
				if (count == 1) {
					ans = c;
					break;
				}
			}
		}
		System.out.println(ans);
	}

}
