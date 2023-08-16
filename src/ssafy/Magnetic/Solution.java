package Magnetic;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testNum = 1; testNum <= 10; testNum++) {

			int answer = 0;

			int[][] board = new int[100][100];
			int length = Integer.parseInt(br.readLine());

			for (int a = 0; a < 100; a++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int b = 0; b < 100; b++) {
					board[a][b] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 100; i++) {
				int preNum = 0;
				for (int j = 0; j < 100; j++) {

					if (board[j][i] == 1) {
						preNum = 1;
					}

					if (board[j][i] == 2) {
						if (preNum == 1) {
							answer++;
						}
						preNum=2;
					}
				}
			}

			System.out.println(String.format("#%d %d", testNum, answer));

		}
	}
}
