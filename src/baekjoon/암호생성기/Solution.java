package 암호생성기;

import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			Deque<Integer> queue = new ArrayDeque();

			for (int i = 0; i < 8; i++) {
				queue.addLast(Integer.parseInt(st.nextToken()));
			}

			int count = 1;

			while (queue.peekLast() > 0) {
				int value = queue.removeFirst();
				if (value - count <= 0) {
					queue.addLast(0);
				} else {
					queue.addLast(value - count);
				}
				if (count < 5) {
					count++;
				} else {
					count = 1;
				}
			}

			String answer = "#" + tc;

			while (!queue.isEmpty()) {
				answer += " " + queue.removeFirst();
			}
			stb.append(answer).append("\n");
		}
		System.out.println(stb.toString());
	}
}
