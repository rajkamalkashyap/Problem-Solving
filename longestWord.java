package gs;

import java.util.ArrayList;

public class longestWord {

	public static void main(String args[]) {
		String[] arr = new String[] { "toes", "dogs" };
		String inp = "osetdg";
		// int[] hash = new int[27];
		boolean[] hash = new boolean[27];
		for (int i = 0; i < inp.length(); i++)
			hash[inp.charAt(i) - 'a'] = true;
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
			if (ans.get(i).length() == max_len)
				System.out.print(ans.get(i) + " ");
		}
		System.out.println();
	}

}
