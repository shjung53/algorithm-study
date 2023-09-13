package 최대상금;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			String strN = "" + n;

			int count = 0;
			Queue<String> queue = new ArrayDeque<>();

			queue.offer(strN);

			int answer = Integer.MIN_VALUE;

			while (!queue.isEmpty()) {
				count++;
				int queueSize = queue.size();
				Set<String> set = new HashSet<>();

				for (int k = 0; k < queueSize; k++) {
					String now = queue.poll();
					for (int i = 0; i < now.length() - 1; i++) {
						for (int j = i + 1; j < now.length(); j++) {
							char[] ca = now.toCharArray();
							char temp = ca[i];
							ca[i] = ca[j];
							ca[j] = temp;
							set.add(String.valueOf(ca));
						}
					}
				}
				for (String next : set) {
					if (count >= m) {
						int num = Integer.parseInt(next);
						if (num > answer)
							answer = num;
					} else {
						queue.add(next);
					}
				}
			}

			System.out.println("#" + tc + " " + answer);

		}
	}
}
