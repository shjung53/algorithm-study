package 직사각형네개의합집합의면적구하기_2669;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		boolean[][] board = new boolean[101][101];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());

			for (int x = leftX; x < rightX; x++) {
				for (int y = leftY; y < rightY; y++) {
					board[x][y] = true;
				}
			}

		}
		for (boolean[] b : board) {
			for (boolean innerB : b) {
				if (innerB)
					answer++;
			}
		}
		System.out.println(answer);
	}
}
