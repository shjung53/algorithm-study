package 색종이_10163;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int[] size;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new int[1001][1001];
		size = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + width; j++) {
				for(int k = y; k < y + height; k++) {
					board[x][y]++;
				}
			}
		}
		
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				if(board[i][j] > 0) {
					int c = board[i][j];
					size[c]++;
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {
			System.out.println(size[i]);
		}
		
		
	}
}
