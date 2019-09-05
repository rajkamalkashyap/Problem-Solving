package gs;

public class DistanceBetweenTwoString {

	public static void main(String[] args) {
		String document = "This is a sample document we just made up";
		// TODO Auto-generated method stub
		double ans = shortestDistance(document, "is", "document");
		System.out.println(ans);
	}

	public static double shortestDistance(String document, String word1, String word2) {
		String[] words = document.split("[,. ]");

		int index = 0;
		double shortest = document.length();
		double word1Loc = 0;
		double word2Loc = 0;
		for (String word : words) {
			// System.out.println("Index:"+index);
			// System.out.println("Current word:"+word);
			if (word.equalsIgnoreCase(word1)) {
				word1Loc = index + (word.length() / 2d);
				// System.out.println("equal word 1:"+word1Loc);
			} else if (word.equalsIgnoreCase(word2)) {
				word2Loc = index + (word.length() / 2d);
				// System.out.println("equal word2:"+word2Loc);
			}

			if (word1Loc > 0 && word2Loc > 0) {
				double current = Math.abs(word1Loc - word2Loc);
				if (current < shortest) {
					shortest = current;
				}
			}

			index += word.length() + 1;
		}

		if (word1Loc == 0 || word2Loc == 0) {
			return -1;
		}

		return shortest;
	}
}
