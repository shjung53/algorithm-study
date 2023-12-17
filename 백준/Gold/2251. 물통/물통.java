import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] water; // 0은 a, 1은 b, 2는 c
	static boolean[][] visited; // a와 c를 기록, b의 높이는 자동으로 알 수 있다.
	static int[] max;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		water = new int[3];
		max = new int[3];
		visited = new boolean[201][201];
		max[0] = Integer.parseInt(st.nextToken());
		max[1] = Integer.parseInt(st.nextToken());
		max[2] = Integer.parseInt(st.nextToken());
		water[2] = max[2];
		list = new ArrayList<Integer>();

		for (int from = 0; from < 3; from++) {
			for (int to = 0; to < 3; to++) {
				pouring(0, from, to);
			}
		}

		Collections.sort(list);

		StringBuilder stb = new StringBuilder();

		for (int liter : list) {
			stb.append(liter).append(' ');
		}

		System.out.println(stb);

	}

	private static void pouring(int turn, int nowFrom, int nowTo) {
		// 같은 물통인 경우
		if (nowFrom == nowTo)
			return;

		// 이미 겪었던 상황인 경우
		if (visited[water[0]][water[2]])
			return;
		
		visited[water[0]][water[2]] = true;

		// a가 빈경우만 답에 포함
		if (water[0] == 0) {
			list.add(water[2]);
		}

		for (int from = 0; from < 3; from++) {
			for (int to = 0; to < 3; to++) {
				if (from == to)
					continue; // 같은 물통일 경우

				if (water[from] == 0)
					continue; // 부을 물통이 없을 경우
				if (water[to] == max[to])
					continue; // 담을 물통이 꽉 찬 경우

				int toTemp = water[to];
				int fromTemp = water[from];

				if (water[to] + water[from] > max[to]) {
					int sub = water[to] + water[from] - max[to];
					water[from] = sub;
					water[to] = max[to];

					pouring(turn + 1, from, to);
					water[from] = fromTemp;
					water[to] = toTemp;
				} else {
					water[to] = water[from] + water[to];
					water[from] = 0;
					pouring(turn + 1, from, to);
					water[to] = toTemp;
					water[from] = fromTemp;
				}
			}
		}
	}
}
