package gs;
//https://www.geeksforgeeks.org/find-subarray-with-given-sum/
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SubArrayOfGivenSum {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {

			while (st == null || !st.hasMoreElements()) {

				try {

					st = new StringTokenizer(br.readLine());

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

			return st.nextToken();

		}

		int nextInt() {

			return Integer.parseInt(next());

		}

		long nextLong() {

			return Long.parseLong(next());

		}

		double nextDouble() {

			return Double.parseDouble(next());

		}

		String nextLine() {

			String str = "";

			try {

				str = br.readLine();

			} catch (IOException e) {

				e.printStackTrace();

			}

			return str;

		}

	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		for (int test = 0; test < t; test++) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			int arr[] = new int[n + 1];
			for (int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				arr[i] = tmp;
			}
			int curr_sum = 0, start = 0, flg = 0;
			for (int i = 0; i < n; i++) {
				curr_sum = curr_sum + arr[i];
				while (curr_sum > sum) {
					curr_sum = curr_sum - arr[start];
					start++;
				}
				if (curr_sum == sum) {
					System.out.println((start + 1) + " " + (i + 1));
					flg = 1;
					break;
				}
			}
			if (flg == 0)
				System.out.println(-1);
		}
	}
}
