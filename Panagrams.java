package gs;

public class Panagrams {

	public static void main(String[] args) {

		String s = "The slow purple oryx meanders past the quiescent canine";
		String strim = s.trim();
		String[] s1 = strim.split(" ");
		String all = "abcdefghijklmnopqrstuvwxyz";
		boolean arr[] = new boolean[26];
		for (int i = 0; i < s1.length; i++) {
			String tmp = s1[i];
			for (int k = 0; k < tmp.length(); k++) {
				char c = tmp.charAt(k);
				char ch = Character.toLowerCase(c);
				if (ch >= 97 && ch <= 122) {
					arr[ch - 'a'] = true;
				}
			}
		}
		String ans = "";
		for (int i = 0; i < all.length(); i++) {
			char c = all.charAt(i);
			if (!(arr[c - 'a']))
				ans = ans + c;
		}
		System.out.println(ans);
	}

}
