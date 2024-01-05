package 행복유치원_13164;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n;
	static int k;
	static int[] height;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		height = new int[n];

		st = new StringTokenizer(br.readLine().trim());

		// 키 순서대로 정렬되어서 들어온다
		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.intValue() - o1.intValue();
			}
		});

		// 키차이를 큐에 넣는다.
		for (int i = 0; i < n - 1; i++) {
			queue.offer(height[i + 1] - height[i]);
		}

		// k조 만큼 나누려면 가장 큰 갭을 k-1만큼 빼서 조를 구성하면 된다.
		for (int i = 0; i < k - 1; i++) {
			queue.poll();
		}

		int cost = 0;
		// 나머지 갭은 전부 티셔츠 비용으로 들어간다.
		while (!queue.isEmpty()) {
			cost += queue.poll();
		}

		System.out.println(cost);

	}
}
