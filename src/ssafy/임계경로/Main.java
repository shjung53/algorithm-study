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
			cities[i] = new City();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			roads[i] = new Road(i, from, to, time);
			cities[from].roadTo.offer(roads[i]);
			cities[to].roadFrom.offer(roads[i]);
			cities[to].roadFrom2.offer(roads[i]);
		}

		st = new StringTokenizer(br.readLine().trim());
		departure = Integer.parseInt(st.nextToken());
		destination = Integer.parseInt(st.nextToken());

		PriorityQueue<Temp> queue = new PriorityQueue<Temp>(new Comparator<Temp>() {
			@Override
			public int compare(Temp o1, Temp o2) {
				// TODO Auto-generated method stub
				return o2.time - o1.time;
			}
		});

		queue.offer(new Temp(departure, 0));

		while (!queue.isEmpty()) {
			Temp nowCity = queue.poll();

			while (!cities[nowCity.cityNum].roadTo.isEmpty()) {
				Road road = cities[nowCity.cityNum].roadTo.poll();
				int toCityNum = road.to;
				cities[toCityNum].roadFrom.remove(road);

				// 이동한 후의 시간이 가장 오래 걸린 시간이면 시간 리셋.
				if (nowCity.time + road.time > cities[toCityNum].time) {
					cities[toCityNum].time = nowCity.time + road.time;
				}

				// 들어가는 도시가 더이상 없으면 큐에 넣기
				if (cities[toCityNum].roadFrom.isEmpty())
					queue.offer(new Temp(toCityNum, cities[toCityNum].time));
			}
		}

		PriorityQueue<City> newQueue = new PriorityQueue<City>(1, new Comparator<City>() {

			@Override
			public int compare(City o1, City o2) {
				// TODO Auto-generated method stub
				return o2.time - o1.time;
			}

		});

		answerTime = cities[destination].time;
		newQueue.offer(cities[destination]);

		boolean[] visited = new boolean[n + 1];
		visited[destination] = true;

		while (!newQueue.isEmpty()) {
			City nowCity = newQueue.poll();

			while (!nowCity.roadFrom2.isEmpty()) {
				Road road = nowCity.roadFrom2.poll();

				// 현재 도시의 시간에서 도로의 시간 뺀 값이 연결된 도시의 값과 같으면 최대시간이 걸린 도시
				if (cities[road.from].time == nowCity.time - road.time) {
					answerRoad++;
					if (!visited[road.from]) {
						visited[road.from] = true;
						newQueue.offer(cities[road.from]);
					}
				}
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

class Temp {
	int cityNum;
	int time; // 이 도시까지온 가장 긴 시간

	public Temp(int cityNum, int time) {
		super();
		this.cityNum = cityNum;
		this.time = time;
	}

}

class City {
	int time = 0; // 이 도시까지 오는 시간
	Comparator<Road> comparator = new Comparator<Road>() {

		@Override
		public int compare(Road o1, Road o2) {
			// TODO Auto-generated method stub
			return o2.time - o1.time;
		}
	};
	PriorityQueue<Road> roadTo = new PriorityQueue<Road>(1, comparator); // 다른 도시로 가는 도로들
	PriorityQueue<Road> roadFrom = new PriorityQueue<Road>(1, comparator); // 이 도시를 향하는 도로들
	PriorityQueue<Road> roadFrom2 = new PriorityQueue<Road>(1, comparator); // 이 도시를 향하는 도로들2
}
