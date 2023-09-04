package 여행가자_1976;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int[] plan;
	static boolean[] visited;
	static boolean[] planCheck;
	static int n;
	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		board = new int[n + 1][n + 1];
		plan = new int[m];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

//		여행지 체크
		planCheck = new boolean[m];
		visited = new boolean[n + 1];
		int start = plan[0];
		bfs(start);
		
		String answer = "YES";
		
//		여행지 연결 안된 부분 있으면 NO
		for(int i=0; i<m; i++) {
			if(!planCheck[i]) answer = "NO";
		}
		System.out.println(answer);
	}

//	BFS로 시작점과 연결된 모든 여행지를 계획과 비교한다.
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		planCheck(start);

		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				int land = queue.poll();
				for (int j = 1; j <= n; j++) {
					if (board[land][j] == 1 && !visited[j]) {
						visited[j] = true;
						planCheck(j);
						queue.offer(j);
					}
				}
			}
		}
	}
	
//	계획에서 여행지 확인해서 체크
	private static void planCheck(int land) {
		for(int i=0; i<m; i++) {
			if(plan[i] == land) {
				planCheck[i] = true;
			}
		}
	}
}
