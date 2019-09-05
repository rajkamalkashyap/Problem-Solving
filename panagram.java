package gs;

public class panagram {

	public static void main(String args[]) {
		String str = "The quick brown fox jumps over the lazy dog";
		boolean hash[] = new boolean[26];
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				int index = c - 'A';
				hash[index] = true;
			}
			if (c >= 'a' && c <= 'z') {
				int index = c - 'a';
				hash[index] = true;
			}
		}

		for (int i = 0; i < 25; i++) {
			if (!hash[i]) {
				flag = 1;
				break;
			}
		}

		if (flag == 1)
			System.out.println("Not panagram");
		else
			System.out.println("panagram");

	}

}
