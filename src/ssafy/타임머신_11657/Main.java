package 타임머신_11657;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static long[][] link;
	static long[] distance;
	static long max = 30000000000L;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		link = new long[n + 1][n + 1];
		distance = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			distance[i] = max;
			for (int j = 1; j <= n; j++) {
				link[i][j] = max;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			// 더 짧은 경로로 설정
			if (time < link[from][to])
				link[from][to] = time;
		}

		// 시작 위치 초기화
		distance[1] = 0;

		// 시작 정점을 제외한 n-1번 돌아서 모든 경로를 확인
		for (int k = 0; k < n - 1; k++) {
			// 모든 정점 돌기
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// 현재 위치에 아직 도달하지 못했으면 그냥 패스
					if (distance[i] == max)
						continue;
					// 간선이 존재
					if (link[i][j] < max) {
						// 현재 위치까지 오는 거리 + 간선 거리가 더 짧으면 거리로 반영
						if (link[i][j] + distance[i] < distance[j]) {
							distance[j] = link[i][j] + distance[i];
						}
					}
				}
			}
		}

		// 사이클 확인
		boolean cycle = false;

		outer: for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				// 시작점과 연결이 안되어 있으면 음의 사이클이 있어도 상관 없다.
				if (distance[i] == max)
					continue;
				// 간선이 존재
				if (link[i][j] < max) {
					// 이미 다 경로 완성되었는데 더 작아진다는건 음의 사이클이 존재한다는 것
					if (link[i][j] + distance[i] < distance[j]) {
						cycle = true;
						if (cycle)
							break outer;
						distance[j] = link[i][j] + distance[i];
					}
				}
			}
		}

		// 사이클 존재하면 -1
		if (cycle) {
			System.out.print(-1);
		} else {
			// 돌면서 거리가 max 그대로면 -1 아니면 거리 출력
			for (int i = 2; i <= n; i++) {
				if (distance[i] == max) {
					System.out.println(-1);
				} else {
					System.out.println(distance[i]);
				}
			}
		}
	}

}
