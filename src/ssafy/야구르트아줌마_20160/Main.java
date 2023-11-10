package 야구르트아줌마_20160;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int v;
	static int e;
	static Node[] nodes;
	static int[] goal = new int[10];
	static int[] myTime;
	static int start;
	static int answer;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		nodes = new Node[v + 1];
		myTime = new int[v + 1];
		answer = Integer.MAX_VALUE;

		for (int i = 1; i <= v; i++) {
			nodes[i] = new Node();
			myTime[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if (nodes[from].map.get(to) == null) {
				nodes[from].map.put(to, new Edge(to, weight));
			} else {
				if (nodes[from].map.get(to).weight > weight)
					nodes[from].map.put(to, new Edge(to, weight));
			}

			if (nodes[to].map.get(from) == null) {
				nodes[to].map.put(from, new Edge(from, weight));
			} else {
				if (nodes[to].map.get(from).weight > weight)
					nodes[to].map.put(from, new Edge(from, weight));
			}
		}

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 10; i++) {
			goal[i] = Integer.parseInt(st.nextToken());
		}
		start = Integer.parseInt(br.readLine().trim());

		setMyTime();

		int idx = 0;
		int time = 0;

		while (idx < 10) {
			// 첫번째 위치까지 가는 시간은 0이다.
			if (idx == 0) {
				idx++;
				continue;
			}

			int now = goal[idx - 1];
			int[] distance = new int[v + 1];
			for (int i = 1; i <= v; i++) {
				distance[i] = Integer.MAX_VALUE;
			}
			distance[now] = time;

			PriorityQueue<Temp> queue = new PriorityQueue<Temp>(1, new Comparator<Temp>() {

				@Override
				public int compare(Temp o1, Temp o2) {
					// TODO Auto-generated method stub
					return o1.time - o2.time;
				}
			});

			queue.add(new Temp(now, time));

			while (!queue.isEmpty()) {
				Temp temp = queue.poll();

				if (temp.time > distance[temp.nodeNum])
					continue;

				for (int edgeNum : nodes[temp.nodeNum].map.keySet()) {
					Edge edge = nodes[temp.nodeNum].map.get(edgeNum);
					if (edge.weight + temp.time <= distance[edge.to]) {
						distance[edge.to] = edge.weight + temp.time;
						queue.add(new Temp(edge.to, edge.weight + temp.time));
					}
				}
			}

			if (distance[goal[idx]] == Integer.MAX_VALUE) {
				idx++;
			} else {
				time = distance[goal[idx]];
				if (distance[goal[idx]] == myTime[goal[idx]]) {
					if (goal[idx] < answer)
						answer = goal[idx];
				}
				if (distance[goal[idx]] > myTime[goal[idx]])
					answer = goal[idx];
			}
		}
		
		System.out.println(answer);

	}

	private static void setMyTime() {

		PriorityQueue<Temp> queue = new PriorityQueue<Temp>(1, new Comparator<Temp>() {
			@Override
			public int compare(Temp o1, Temp o2) {
				// TODO Auto-generated method stub
				return o1.time - o2.time;
			}
		});

		myTime[start] = 0;

		queue.add(new Temp(start, 0));

		while (!queue.isEmpty()) {
			Temp temp = queue.poll();

			if (temp.time > myTime[temp.nodeNum])
				continue;

			for (int edgeNum : nodes[temp.nodeNum].map.keySet()) {
				Edge edge = nodes[temp.nodeNum].map.get(edgeNum);
				if (edge.weight + temp.time <= myTime[edge.to]) {
					myTime[edge.to] = edge.weight + temp.time;
					queue.add(new Temp(edge.to, edge.weight + temp.time));
				}
			}
		}

	}

}

class Temp {
	int nodeNum;
	int time = 0;

	public Temp(int nodeNum, int time) {
		super();
		this.nodeNum = nodeNum;
		this.time = time;
	}
}

class Node {
	int time = 0;
	// 노드가 가지는 <목적지, 도로> 맵
	HashMap<Integer, Edge> map = new HashMap<>();
}

class Edge {
	int to;
	int weight;

	public Edge(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}

}
