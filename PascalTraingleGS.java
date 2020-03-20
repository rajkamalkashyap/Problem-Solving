package gs;

import java.util.HashMap;
import java.util.Map;

public class PascalTraingleGS {
	public static Map<Integer, Map<Integer, Integer>> pascalHash = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = pascal(3, 5);
		System.out.println(ans);
	}

	public static int pascal(int col, int row) {
		if (col == 0 || col == row) {
			return 1;
		}
		int pascalValue = 0;
		if (pascalHash.containsKey(col)) {
			if (pascalHash.get(col).containsKey(row)) {
				return pascalHash.get(col).get(row);
			} else {
				pascalValue = pascal(col, row - 1) + pascal(col - 1, row - 1);
				pascalHash.get(col).put(row, pascalValue);
			}
		} else {
			pascalValue = pascal(col, row - 1) + pascal(col - 1, row - 1);
			Map<Integer, Integer> rowHashMap = new HashMap();
			rowHashMap.put(row, pascalValue);
			pascalHash.put(col, rowHashMap);
		}
		return pascalValue;
	}
}
