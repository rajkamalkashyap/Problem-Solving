package gs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class bestAverageGrade {
	public static void main(String args[]) {
		double bestAvg = Integer.MIN_VALUE;
		String[][] newArray = { { "Bobby", "87" }, { "Charles", "100" }, { "Eric", "64" }, { "Charles", "22" } };
		HashMap<String, ArrayList<Integer>> values = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < newArray.length; i++) {
			// System.out.println(newArray[i][0] + " " + newArray[i][1]);
			if (values.containsKey(newArray[i][0])) {
				ArrayList<Integer> xx = values.get(newArray[i][0]);
				Integer tmp = Integer.parseInt(newArray[i][1]);
				xx.add(tmp);
				values.put(newArray[i][0], xx);
			} else {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(Integer.parseInt(newArray[i][1]));
				values.put(newArray[i][0], tmp);
			}
		}

		// System.out.println(values);

		for (Entry<String, ArrayList<Integer>> i : values.entrySet()) {
			// System.out.println(i.getKey()+" "+i.getValue());
			ArrayList<Integer> val = i.getValue();
			double sum = val.stream().mapToDouble(a -> a).sum();
			double avg = sum / (val.size());
			if (avg > bestAvg)
				bestAvg = avg;
		}

		System.out.println(bestAvg);
	}
}
