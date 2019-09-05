package gs;

public class WakingRobot {

	public static void main(String args[]) {
		String s = "UDDLLRUUUDUURUDDUULLDRRRR";
		int x = 0, y = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'U') {
				y++;
			} else if (c == 'D') {
				y--;
			} else if (c == 'L') {
				x--;
			} else if (c == 'R') {
				x++;
			}
		}
		System.out.println(x + " " + y);
	}
}
