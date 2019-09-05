package gs;

import java.util.HashSet;

public class UniqueTuple {

	public static void main(String[] args) {
		String s = "aab";
		Integer n = s.length(), len = 2;
		HashSet<String> ans = new HashSet<String>();
		for (int i = 0; i < n - len + 1; i++) {
			ans.add(s.substring(i, i + len));
		}
		System.out.println(ans);
	}
}

//   
