package 단지번호붙이기_2667;

import java.util.*;
import java.io.*;

public class Main {
	static int[][]board;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int length;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		length = Integer.parseInt(br.readLine());
		
		board = new int[length][length];
		
		for (int i = 0; i < length; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < length; j++) {
				board[i][j] = Character.getNumericValue(chars[j]);
			}
		}
		
		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (board[i][j] == 1) {
					int clusterSize = countCluster(i, j, 0);
					arr.add(clusterSize);
				}
			}
		}
		
		Collections.sort(arr);
		
		System.out.println(arr.size());
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	
	private static int countCluster(int y, int x, int count) {
		if(board[y][x] > 0) {
			count++;
			board[y][x] = 0;
		}
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(check(newY, newX)) {
				if(board[newY][newX] != 0) {
					count = countCluster(newY, newX, count);
				}
			}
		}
		return count;
	}
	
	private static boolean check (int y, int x) {
		return x >= 0 && x < length && y >= 0 && y <length;
	}
}
