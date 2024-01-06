package Ladder1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			int testNum = Integer.parseInt(br.readLine());
			int[][] board = new int[100][100];

			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 100; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int destinationX = 0;

			for (int d = 0; d < 100; d++) {
				if (board[99][d] == 2) {
					destinationX = d;
					break;
				}
			}

			int y = 99;
			int x = destinationX;
			int answer = 0;
			int preX = x;

			while (y > 0) {
				boolean isSwitched = false;
				if (x + 1 < 100) {
					if (board[y][x + 1] == 1) {
						if (x + 1 != preX) {
							preX = x;
							x = x + 1;
							isSwitched = true;
						}
					}
				}

				if (isSwitched)
					continue;

				if (x - 1 >= 0) {
					if (board[y][x - 1] == 1) {
						if (x - 1 != preX) {
							preX = x;
							x = x - 1;
							isSwitched = true;
						}
					}
				}

				if (isSwitched) {
					continue;
				} else {
					preX = -1;
					y = y - 1;
				}

			}

			answer = x;
			System.out.println(String.format("#%d %d", testNum, answer));
		}

	}
}
