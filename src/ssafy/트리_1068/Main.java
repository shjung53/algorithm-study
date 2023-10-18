package 트리_1068;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int[] parent;
	static int n;
	static int delete;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());

		parent = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int nodeIdx = 0; nodeIdx < n; nodeIdx++) {
			parent[nodeIdx] = Integer.parseInt(st.nextToken());
		}

		// 지워야 하는 노드 등장
		delete = Integer.parseInt(br.readLine().trim());

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(delete);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			parent[now] = -2; // 부모와 끊기
			for (int nodeIdx = 0; nodeIdx < n; nodeIdx++) {
				if (parent[nodeIdx] == now) {
					parent[nodeIdx] = -2; // 부모를 없애서 끊는다.
					queue.offer(nodeIdx); // 자식들도 부모와 끊기 위해 추가 한다.
				}
			}
		}
		answer = 0;

		Loop: for (int checkNode = 0; checkNode < n; checkNode++) {
			if (parent[checkNode] == -2)
				continue; // 부모와 끊어져 있으면 체크 안함
			// 돌면서 누군가 이 노드를 부모로 가지고 있으면 답 추가 안함
			for (int nodeIdx = 0; nodeIdx < n; nodeIdx++) {
				if (parent[nodeIdx] == checkNode)
					continue Loop;
			}
			answer++;
		}
		System.out.println(answer);
	}
}
