package 치즈_2636;

import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] board;
	static int h;
	static int w;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		board = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int second = 0;
		int beforeCount =0;
		count = 0;
		countPiece(board);
		meetAir(0, 0);
		
		while(count > 0) {
			second++;
			eraseHole();
			beforeCount = count;
			count = 0;
			countPiece(board);
		}
		
		System.out.println(second);
		System.out.println(beforeCount);
		
		
	}

	private static void meetAir(int y, int x) {
		if (board[y][x] == 0) {
			board[y][x] = -1;
		}

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (check(newY, newX)) {
				if (board[newY][newX] == 1) {
					board[newY][newX] = 2;
				}
				if (board[newY][newX] == 0) {
					meetAir(newY, newX);
				}
			}
		}
	}
	
	private static void eraseHole() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if(board[i][j] == 2) board[i][j] = 0;
			}
		}
	}

	private static boolean check(int y, int x) {
		if (x < 0 || x >= w || y < 0 || y >= h)
			return false;
		return true;
	}

	private static void countPiece(int[][] snapBoard) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (snapBoard[i][j] == 1) {
					dfs(snapBoard, i, j);
					count++;
				}
			}
		}
	}

	private static void dfs(int[][] snapBoard, int y, int x) {
		snapBoard[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (check(newY, newX)) {
				if (snapBoard[newY][newX] == 1) {
					dfs(snapBoard, newY, newX);
				}
			}
		}

	}

}
