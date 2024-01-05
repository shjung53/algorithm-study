package 메모리;

import java.util.*;
import java.io.*;

public class Solution {
	static int[][] board = new int[16][16];
	static int startY;
	static int startX;
	static int endY;
	static int endX;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			int answer = 0;

			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					int value = Character.getNumericValue(line.charAt(j));
					if (value == 2) {
						startY = i;
						startX = j;
					}

					if (value == 3) {
						endY = i; 
						endX = j;
					}

					board[i][j] = value;
				}
			}

			Queue<int[]> queue = new ArrayDeque<>();

			queue.offer(new int[] {startY, startX});

			Loop :
			while (!queue.isEmpty()) {
				int[] location = queue.poll();
				int i = location[0];
				int j = location[1];

				for (int k = 0; k < 4; k++) {
					int newY = i + dy[k];
					int newX = j + dx[k];
					if (newY > 0 && newY < 16 && newX > 0 && newX < 16) {
						
						if (board[newY][newX] == 3) {
							answer = 1;
							break Loop;
						}
						
						if (board[newY][newX] != 1) {
							board[newY][newX] = 1;
							queue.offer(new int[] {newY, newX});
						}
					}
				}
			}
			
			stb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(stb.toString());
	}
	
}
