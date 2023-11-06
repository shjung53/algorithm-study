package 최단경로_1753;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int v; // 정점의 개수
	static int e; // 간선의 개수
	static int start; // 시작 정점
	static Edge[] edges;
	static Node[] nodes;
	static int[] visited; // 정점 방문 시점의 가중치

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		nodes = new Node[v + 1];
		edges = new Edge[e];
        visited = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			nodes[i] = new Node();
            visited[i] = Integer.MAX_VALUE;
		}

		for (int eIdx = 0; eIdx < e; eIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[eIdx] = new Edge(from, to, weight);
			nodes[from].edges.add(eIdx);
		}

		bfs(start);

		for (int i = 1; i <= v; i++) {
			if (i == start) {
				stb.append(0).append('\n');
				continue;
			}

			if (visited[i] == Integer.MAX_VALUE) {
				stb.append("INF").append('\n');
				continue;
			}

			stb.append(visited[i]).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void bfs(int start) {
		PriorityQueue<Loc> queue = new PriorityQueue<Loc>(1, new Comparator<Loc>() {
			@Override
			public int compare(Loc o1, Loc o2) {
				// TODO Auto-generated method stub
				return visited[o1.nowIdx] - visited[o2.nowIdx];
			}
        });
		queue.offer(new Loc(0, start)); // 시작노드를 넣는다.
        

		while (!queue.isEmpty()) {
			Loc nowLoc = queue.poll();
			Node now = nodes[nowLoc.nowIdx];
            
            if(nowLoc.weight > visited[nowLoc.nowIdx]) continue;

			for (int eIdx = 0; eIdx < now.edges.size(); eIdx++) {
				Edge edge = edges[now.edges.get(eIdx)];
                if(nowLoc.weight + edge.weight >= visited[edge.to]) continue;
                
                visited[edge.to] = nowLoc.weight + edge.weight;
				queue.offer(new Loc(visited[edge.to], edge.to));
			}
		}
	}
}

class Loc {
    int weight;
    int nowIdx;
    public Loc(int weight, int nowIdx) {
        super();
        this.weight = weight;
        this.nowIdx = nowIdx;
    } 
}

class Edge {
	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

class Node {
	ArrayList<Integer> edges = new ArrayList<Integer>();
}
