package n과m9_15663;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] nums;
	static boolean[] visited;
	static int[] check;
	static StringBuilder stb;
	static LinkedHashSet<String> set;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		set = new LinkedHashSet<>();

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		visited = new boolean[n];
		check = new int[m];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		permutation(0);

		for (String answer : set) {
			System.out.println(answer);
		}

	}

	public static void permutation(int idx) {

		if (idx >= m) {
			stb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				stb.append(check[i]).append(' ');
			}
			set.add(stb.toString());
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			check[idx] = nums[i];
			permutation(idx + 1);
			visited[i] = false;
		}

	}
}
