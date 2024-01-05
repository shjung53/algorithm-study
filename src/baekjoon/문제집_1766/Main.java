package 문제집_1766;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static Problem[] problems;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		StringBuilder stb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		problems = new Problem[n + 1];

		for (int i = 1; i <= n; i++) {
			problems[i] = new Problem();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			problems[before].after.add(after);
			problems[after].before.add(before);
		}

		// 쉬운 문제 우선
		PriorityQueue<Integer> queue = new PriorityQueue<>(1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});

		for (int i = 1; i <= n; i++) {
			if (problems[i].before.size() == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int problem = queue.poll();
			stb.append(problem).append(' ');

			for (int nextProblem : problems[problem].after) {
				problems[nextProblem].before.remove(problem); // 다음 문제의 선행문제에서 현재 문제 지우기
				if (problems[nextProblem].before.size() == 0) // 다음 문제의 선행문제가 더이상 없으면 임시문제에 넣기
					queue.offer(nextProblem);
			}

		}
		System.out.println(stb);
	}

}

class Problem {
	HashSet<Integer> before = new HashSet<Integer>();
	HashSet<Integer> after = new HashSet<Integer>();
}
