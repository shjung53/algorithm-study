package GNS;

import java.util.*;
import java.io.*;

public class Solution {
	static String[] num = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String test = st.nextToken();
			int n = Integer.parseInt(st.nextToken());

			String str = br.readLine();
			String[] arr = str.split(" ");
			int[] intArr = new int[n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 10; j++) {
					if (num[j].equals(arr[i])) {
						intArr[i] = j;
					}
				}
			}

			Arrays.sort(intArr);

			for (int i = 0; i < n; i++) {
				arr[i] = num[intArr[i]];
			}

			String answer = Arrays.toString(arr);
			answer = answer.replaceAll(",", "");
			answer = answer.substring(1, answer.length() - 1);

			stb.append(test).append('\n').append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}
}
