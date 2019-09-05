package gs;

public class MagicPotion {
	public static void main(String args[]) {
		String str = "ABCABCE";
		int ans = minimalSteps(str);
		System.out.println(ans);
	}

	private static int minimalSteps(String ingredients) {
		String ans = "";
		String intermediateIng = "";
		int i = 0;
		while (i < ingredients.length()) {
			if (intermediateIng.length() > 0 && (i + intermediateIng.length() < ingredients.length())
					&& ingredients.substring(i, i + intermediateIng.length()).equals(intermediateIng)) {
				ans = ans + "*";
				i = i + intermediateIng.length();
				intermediateIng = intermediateIng + intermediateIng;

			} else {
				ans = ans + ingredients.charAt(i);
				intermediateIng = intermediateIng + ingredients.charAt(i);
				i++;
			}
		}
		System.out.println(ans);
		return ans.length();
	}
}
