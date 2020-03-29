package gs.practiceCode;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

//  Find the best average grade.
//  Given a list of student test scores
//  Each student may have more than one test score in the list.

class testInGsFormat_practice {
	public static Integer bestAvgGrade(String[][] scores) {

		double bestAvg = Integer.MIN_VALUE;
		//String[][] newArray = { { "Bobby", "87" }, { "Charles", "100" }, { "Eric", "64" }, { "Charles", "22" } };
		//String[][]  newArray={};
		HashMap<String, ArrayList<Integer>> values = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < scores.length; i++) {
			// System.out.println(newArray[i][0] + " " + newArray[i][1]);
			if (values.containsKey(scores[i][0])) {
				ArrayList<Integer> xx = values.get(scores[i][0]);
				Integer tmp = Integer.parseInt(scores[i][1]);
				xx.add(tmp);
				values.put(scores[i][0], xx);
			} else {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(Integer.parseInt(scores[i][1]));
				values.put(scores[i][0], tmp);
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
		if(scores.length == 0)
			return 0;
		else	
			return (int)Math.floor(bestAvg);
	}

	public static boolean pass() {
		String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" } };

		return bestAvgGrade(s1) == 84;
	}

	public static void main(String[] args) {
		if (pass()) {
			System.out.println("Pass");
		} else {
			System.out.println("Some Fail");
		}
	}
}
