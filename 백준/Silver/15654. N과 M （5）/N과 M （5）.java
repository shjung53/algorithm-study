import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] nums;
	static int[] answer;
	static boolean[] visited;
	static StringBuilder stb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stb = new StringBuilder();

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		visited = new boolean[n];
		answer = new int[m];
		combi(0, 0);

		System.out.println(stb);

	}

	public static void combi(int idx, int count) {

		if (count == m) {
			for (int i = 0; i < m; i++) {
				stb.append(answer[i]).append(' ');
			}
			stb.append('\n');
			return;
		}

		if (idx >= m)
			return;

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			answer[idx] = nums[i];
			combi(idx + 1, count + 1);
			visited[i] = false;
		}

	}
}
