package 부분합_1806;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] arr;
	static int n;
	static int s;
	static int answer;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int[n];
		answer = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] >= s)
				answer = 1;
		}

		int left = 0;
		int right = 1;
		int sum = arr[left] + arr[right];

		if (answer == 1) {
			System.out.println(answer);
			return;
		}

		while (right < n) {
			if (sum >= s) {
				if (right - left + 1 < answer)
					answer = right - left + 1;

				sum -= arr[left];
				left++;
				if (right < left) {
					answer = right - left + 1;
					break;
				}
				continue;
			}

			if (sum < s) {
				right++;
				if (right >= n)
					break;
				sum += arr[right];
			}
		}

		if (answer == Integer.MAX_VALUE)
			answer = 0;

		System.out.println(answer);

	}
}
