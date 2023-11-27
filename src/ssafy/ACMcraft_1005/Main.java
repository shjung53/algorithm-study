package ACMcraft_1005;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n;
	static int k;

	static Building[] buildings;
	static int[] steps;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());

		StringBuilder stb = new StringBuilder();

		Loop: for (int testCase = 0; testCase < test; testCase++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			buildings = new Building[n + 1];
			steps = new int[n + 1];

			st = new StringTokenizer(br.readLine().trim());
			for (int i = 1; i <= n; i++) {
				buildings[i] = new Building(Integer.parseInt(st.nextToken()));
			}

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int before = Integer.parseInt(st.nextToken());
				int after = Integer.parseInt(st.nextToken());
				buildings[before].afters.add(after);
				buildings[after].befores.add(before);
			}

			Queue<Step> queue = new ArrayDeque<>();

			int goal = Integer.parseInt(br.readLine().trim()); // 목표 빌딩
			for (int i = 1; i <= n; i++) {
				if (buildings[i].befores.isEmpty()) {
					queue.offer(new Step(i, buildings[i].time)); // 시작점 빌딩들 다 넣기
					steps[i] = buildings[i].time;
					if (goal == i) {
						System.out.println(steps[i]);
						continue Loop;
					}
				}
			}

			steps = new int[n + 1]; // 빌딩 건설 시간 기록, 작으면 넣지 않는다.

			while (!queue.isEmpty()) {
				Step step = queue.poll();

				int index = step.index;

				for (int next : buildings[index].afters) {
					buildings[next].befores.remove(index); // 다음에 지을 수 있는 빌딩들의 필수 요소에서 삭제

					if (step.time + buildings[next].time <= steps[next])
						continue; // 다음 스텝이 이전에 지나간 스텝들보다 같거나 작으면 패스

					steps[next] = step.time + buildings[next].time; // 크다면 기록

					// 필수 건물 다 지었으면 가장 오래걸린 시간으로 큐에 넣는다
					if (buildings[next].befores.isEmpty()) {
						queue.offer(new Step(next, steps[next]));
					}
				}
			}

			stb.append(steps[goal]).append('\n');
		}

		System.out.println(stb);
	}
}

class Step {
	int index;
	int time;

	public Step(int index, int time) {
		this.index = index;
		this.time = time;
	}
}

class Building {
	int time;
	Set<Integer> afters = new HashSet<>(); // 다음에 지을 수 있는 빌딩들
	Set<Integer> befores = new HashSet<>(); // 이전에 지어야 하는 빌딩들

	public Building(int time) {
		this.time = time;
	}
}
