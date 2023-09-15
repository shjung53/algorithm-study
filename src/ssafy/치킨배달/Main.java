package 치킨배달;

import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = { 1, 1, 1, 0, -1, -1, -1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static boolean[][] visited;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}
}
