package gs;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.HashMap;

import java.util.Map.Entry;

public class GroupAnagrams {

	public static void main(String[] args) {

		String[] words = { "CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE", "PAIRED", "ARCS", "GRAB", "USED", "ONES",

				"BRAG", "SUED", "LEAN", "SCAR", "DESIGN" };
		groupAnagrams(words);

	}

	private static void groupAnagrams(String[] words) {
		HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < words.length; i++) {
			String tmp = words[i];
			char tempArray[] = tmp.toCharArray();
			Arrays.sort(tempArray);
			String tm = new String(tempArray);
			if (hm.containsKey(tm)) {
				ArrayList<Integer> xx = hm.get(tm);
				xx.add(i);
				hm.put(tm, xx);
			} else {
				ArrayList<Integer> xx1 = new ArrayList<Integer>();
				xx1.add(i);
				hm.put(tm, xx1);
			}
		}

		for (Entry<String, ArrayList<Integer>> i : hm.entrySet()) {
			ArrayList<Integer> xx = i.getValue();
			for (int k = 0; k < xx.size(); k++) {
				int val = xx.get(k);
				System.out.print(words[val] + " ");
			}
			System.out.println();
		}

	}

}
