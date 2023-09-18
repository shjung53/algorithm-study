package 보석상자_2792;

import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] jewelry;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		jewelry = new int[m];

		for (int i = 0; i < m; i++) {
			jewelry[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewelry);

		int start = 1;
		int end = jewelry[m - 1];

		while (start <= end) {
			int mid = (start + end) / 2;
			int count = 0;

			for (int i = 0; i < m; i++) {
				count += jewelry[i] / mid;
				if(jewelry[i] % mid > 0) count ++;
			}
			
			if(count > n) start = mid + 1;
			if(count <= n) end = mid - 1;

		}
		System.out.println(start);

	}
}
