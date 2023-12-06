package 앱_7579;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static App[] apps;
	static int answer;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		apps = new App[n];
		answer = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			apps[i] = new App(i, Integer.parseInt(st.nextToken()), 0);
		}

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			apps[i].cost = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 0);

		System.out.println(answer);

	}

	private static void dfs(int num, int memorySum, int totalCost) {
		if (memorySum >= m) {
			if (totalCost < answer)
				answer = totalCost;
			return;
		}

		if (num >= n)
			return;

		if (totalCost >= answer)
			return;

		App app = apps[num];

		dfs(num + 1, memorySum + app.memory, totalCost + app.cost);
		dfs(num + 1, memorySum, totalCost);
	}
}

class App {
	int num;
	int memory;
	int cost;

	public App(int num, int memory, int cost) {
		super();
		this.num = num;
		this.memory = memory;
		this.cost = cost;
	}

}
