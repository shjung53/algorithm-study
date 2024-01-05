package 최소비용구하기_1916;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static ArrayList<Road>[] cities;
	static int[] minCost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		m = Integer.parseInt(br.readLine().trim());

		cities = new ArrayList[n + 1];
		minCost = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			cities[i] = new ArrayList<>();
			minCost[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			cities[from].add(new Road(to, cost));
		}

		st = new StringTokenizer(br.readLine().trim());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		minCost[start] = 0;

		Queue<Move> queue = new ArrayDeque<Move>();

		queue.offer(new Move(start, 0));

		while (!queue.isEmpty()) {
			Move now = queue.poll();
			if (now.totalCost > minCost[now.city])
				continue;

			for (Road road : cities[now.city]) {
				if (minCost[road.to] <= now.totalCost + road.cost)
					continue;
				minCost[road.to] = now.totalCost + road.cost;
				queue.offer(new Move(road.to, now.totalCost + road.cost));
			}
		}

		System.out.println(minCost[end]);
	}

}

class Move {
	int city;
	int totalCost;

	public Move(int city, int totalCost) {
		super();
		this.city = city;
		this.totalCost = totalCost;
	}

}

class Road {
	int to;
	int cost;

	public Road(int to, int cost) {
		super();
		this.to = to;
		this.cost = cost;
	}

}
