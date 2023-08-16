package 수열_2559;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n - k + 1; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += arr[i + j];
			}
			if (sum > max)
				max = sum;
		}

		System.out.println(max);
	}
}
