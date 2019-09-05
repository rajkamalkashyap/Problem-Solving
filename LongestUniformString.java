package gs;

public class LongestUniformString {

	public static void main(String[] args) {
		String s = "10000111";
		int max = Integer.MIN_VALUE;
		int startIndex = -1, ansIndex = -1;
		int l = s.length();
		for (int i = 0; i < l; i++) {
			int count = 1;
			startIndex = i;
			while (i < l - 1 && s.charAt(i) == s.charAt(i + 1)) {
				count++;
				i++;
			}
			if (count > max) {
				max = count;
				ansIndex = startIndex;
			}
		}
		System.out.println(ansIndex + " " + max);
	}

}
