package 작업순서;

import java.util.*;
import java.io.*;

public class Solution {

	static int[][] board;
	static int edge;
	static int line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String answer = "";

			edge = Integer.parseInt(st.nextToken());
			line = Integer.parseInt(st.nextToken());
			board = new int[edge + 1][edge + 1];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < line; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				board[from][to]++;
			}

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 1; i < edge + 1; i++) {
				queue.offer(i);
			}

			while (!queue.isEmpty()) {
				int nowE = queue.poll();

				boolean hasNoFrom = true;

				for (int i = 1; i < edge + 1; i++) {
					if (board[i][nowE] > 0)
						hasNoFrom = false;
				}

				if (hasNoFrom) {
					answer += nowE + " ";
					for (int i = 1; i < edge + 1; i++) {
						board[nowE][i] = 0;
					}
				} else {
					queue.offer(nowE);
				}
			}
			
			answer = answer.substring(0, answer.length()-1);

			System.out.println("#" + t + " " +  answer);
		}
	}

}
