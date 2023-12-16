package 물통_2251;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] water; // 0은 a, 1은 b, 2는 c
	static int[] max;
	static HashSet<Integer> set;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		water = new int[3];
		max = new int[3];
		max[0] = Integer.parseInt(st.nextToken());
		max[1] = Integer.parseInt(st.nextToken());
		max[2] = Integer.parseInt(st.nextToken());
		water[2] = max[2];
		set = new HashSet<>();

		for (int from = 0; from < 3; from++) {
			for (int to = 0; to < 3; to++) {
				pouring(0, from, to);
			}
		}

		list = new ArrayList<Integer>();
		list.addAll(set);
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
		if (set.contains(water[2]))
			return;

		// a가 빈경우만 답에 포함
		if (water[0] == 0) {
			set.add(water[2]);
		}

		if (turn > Math.ceil((double) max[2] / max[0]) * 2 && turn >= 3)
			return; // a 물통으로 c 물통 계속 퍼나르는 경우인 동시에 최소 3번은 옮길 수 있어야 함

		for (int from = 0; from < 3; from++) {
			for (int to = 0; to < 3; to++) {
				if (from == to)
					continue; // 같은 물통일 경우

				if (nowFrom == to && nowTo == from)
					continue; // 이전에 한 행동 되돌릴 경우

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
