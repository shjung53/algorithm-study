package 균형점;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] x = new int[n];
			int[] m = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				m[i] = Integer.parseInt(st.nextToken());
			}

		}
	}
}
