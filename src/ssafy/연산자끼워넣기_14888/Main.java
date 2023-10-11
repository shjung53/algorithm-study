package 연산자끼워넣기_14888;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] count;
	static int[] num;
	static int[] order;
	static int min;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		count = new int[4];
		num = new int[n];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		order = new int[n - 1];
		set(0);
		System.out.println(max);
		System.out.println(min);

	}

	private static void set(int idx) {

		if (idx == n - 1) {
			int result = num[0];
			for (int i = 0; i < n - 1; i++) {
				switch (order[i]) {
				case 0:
					result += num[i + 1];
					break;
				case 1:
					result -= num[i + 1];
					break;
				case 2:
					result *= num[i + 1];
					break;
				case 3:
					result /= num[i + 1];
					break;
				}
			}
			
			if(max < result) max = result;
			if(min > result) min = result;
			
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (count[i] > 0) {
				count[i]--;
				switch (i) {
				case 0:
					order[idx] = 0;
					break;
				case 1:
					order[idx] = 1;
					break;
				case 2:
					order[idx] = 2;
					break;
				case 3:
					order[idx] = 3;
					break;
				}

				set(idx + 1);
				count[i]++;
			}
		}
	}
}
