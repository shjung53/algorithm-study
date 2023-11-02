package 줄세우기_2252;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static Student[] students;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		StringBuilder stb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		students = new Student[n + 1];

		for (int i = 1; i <= n; i++) {
			students[i] = new Student();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int shorter = Integer.parseInt(st.nextToken());
			int taller = Integer.parseInt(st.nextToken());
			students[taller].shorters.add(shorter);
			students[shorter].tallers.add(taller);
		}

		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			if (students[i].shorters.size() == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int shortest = queue.poll();
			stb.append(shortest).append(' ');

			for (int taller : students[shortest].tallers) {
				students[taller].shorters.remove(shortest);
				if (students[taller].shorters.size() == 0)
					queue.offer(taller);
			}

		}
		System.out.println(stb);
	}

}

class Student {
	HashSet<Integer> tallers = new HashSet<Integer>();
	HashSet<Integer> shorters = new HashSet<Integer>();
}
