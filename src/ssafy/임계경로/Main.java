package 임계경로;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static City[] cities;
	static Road[] roads;
	static int departure;
	static int destination;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		n = Integer.parseInt(br.readLine().trim());
		m = Integer.parseInt(br.readLine().trim());
		cities = new City[n + 1];
		roads = new Road[m];
		int answerTime = 0;
		int answerRoad = 0;

		for (int i = 1; i <= n; i++) {
			cities[i] = new City(m, i);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			roads[i] = new Road(i, from, to, time);
			cities[from].roadTo.add(i);
			cities[to].roadFrom.add(i);
		}

		st = new StringTokenizer(br.readLine().trim());
		departure = Integer.parseInt(st.nextToken());
		destination = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(departure);

		while (!queue.isEmpty()) {
			int nowCityNum = queue.poll();
			City nowCity = cities[nowCityNum];

			if (nowCityNum == destination) {
				answerTime = nowCity.time;

				for (int i = 0; i < m; i++) {
					if (nowCity.visited[i])
						answerRoad++;
				}
				continue;
			}

			for (int roadNum : nowCity.roadTo) {
				Road road = roads[roadNum];
				int toCityNum = road.to;
				cities[toCityNum].roadFrom.remove(roadNum); // 이동한 후 도시로 이동하는 도로 제거

				// 이동한 후의 시간이 가장 오래 걸린 시간이면 거친 도로 목록을 리셋 혹은 시간이 같으면 거친 도로 목록을 추가해준다.
				if (nowCity.time + road.time > cities[toCityNum].time) {
					cities[toCityNum].time = nowCity.time + road.time;
					for (int i = 0; i < m; i++) {
						if (nowCity.visited[i]) {
							cities[toCityNum].visited[i] = true;
						} else {
							cities[toCityNum].visited[i] = false;
						}
					} // 오래 걸렸으면 이 도로 목록으로 업데이트
					cities[toCityNum].visited[toCityNum] = true;
				} else if (nowCity.time + road.time == cities[road.to].time) {
					for (int i = 0; i < m; i++) {
						if (nowCity.visited[i])
							cities[toCityNum].visited[i] = true;
					}
				}

				if (cities[road.to].roadFrom.size() == 0)
					queue.offer(road.to); // 더 이상 들어오는 도로가 없으면 도시를 추가한다.
			}
		}

		stb.append(answerTime).append('\n');
		stb.append(answerRoad);
		System.out.println(stb);
	}

}

class Road {
	int num;
	int time;
	int from;
	int to;

	public Road(int num, int from, int to, int time) {
		super();
		this.num = num;
		this.from = from;
		this.to = to;
		this.time = time;
	}
}

class City {
	int time; // 이 도시까지온 가장 긴 시간
	boolean[] visited; // 가장 긴 시간일때 거친 도로들
	HashSet<Integer> roadTo = new HashSet<Integer>(); // 다른 도시로 가는 도로들
	HashSet<Integer> roadFrom = new HashSet<Integer>(); // 이 도시를 향하는 도로들

	public City(int m, int cityNum) {
		super();
		this.visited = new boolean[m];
		this.visited[cityNum] = true;
	}
}
