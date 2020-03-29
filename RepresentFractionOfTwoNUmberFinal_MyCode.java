package gs.practiceCode;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;

public class testInGsFormat_practice {
	/**
	 * Return the fraction output in the following way Examples: If after decimal,
	 * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
	 * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
	 * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
	 * fractionRepresentation(6,11)=0.(54)
	 */
	public static String fractionRepresentation(int num, int den) {
		
		if (num == 0)
			return "0";
		if (den == 0)
			return "";

		String result = "";

		// is result is negative
		/*if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}*/
		
		if ((num < 0 || den < 0) && !(num < 0 && den < 0))
			result += "-";

		// convert int to long
		long numerator = num, denominator = den;
		numerator = Math.abs(num);
		denominator = Math.abs(den);

		// quotient
		long res = numerator / denominator;
		result += String.valueOf(res);
		//System.out.println(result);
		// if remainder is 0, return result
		long remainder = (numerator % denominator) * 10;
		//System.out.println(remainder);
		if (remainder == 0)
			return result;

		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder);
				//System.out.println("result:"+result);
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}

			// continue
			//System.out.println("Check" + remainder + " " + result.length() + " " + result);
			map.put(remainder, result.length());
			res = remainder / denominator;
			result += String.valueOf(res);
			remainder = (remainder % denominator) * 10;
			//System.out.println(result);
		}

		return result;
	
	}

	public static void main(String args[]) {
		// float f=6/11f;
		// System.out.println(f);
		System.out.println(fractionRepresentation(1, 2) + " " + fractionRepresentation(1, 3) + " "
				+ fractionRepresentation(6, 11));

		if (fractionRepresentation(1, 2).equals("0.5") && fractionRepresentation(6, 11).equals("0.(54)")
				&& fractionRepresentation(1, 3).equals("0.(3)")) {
			System.out.println("All passed");
		} else {
			System.out.println("Failed");
		}

	}
}
