package 뉴스전하기_1135;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static Clerk[] clerks;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		clerks = new Clerk[n];
		st = new StringTokenizer(br.readLine().trim());
		dp = new int[n];

		for (int i = 0; i < n; i++) {
			clerks[i] = new Clerk();
		}

		for (int i = 0; i < n; i++) {
			int boss = Integer.parseInt(st.nextToken());
			if (boss == -1)
				continue;
			clerks[boss].underling.add(i);
		}

		getDP(0);
		System.out.println(dp[0]);

	}

	private static int getDP(int clerkIdx) {

		// 걸리는 시간 -> 직원한테 전화하면서 늘어난다.
		int waitSecond = 1;
		int max = 0; // 가장 오래 걸리는 시간이 이 직원의 dp값, 부하 직원 모두에게 전달되는 시간

		if (clerks[clerkIdx].underling.size() == 0)
			return dp[clerkIdx] = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(1, Collections.reverseOrder());

		for (int i = 0; i < clerks[clerkIdx].underling.size(); i++) {
			int underlingIdx = clerks[clerkIdx].underling.get(i);
			queue.offer(getDP(underlingIdx)); // 부하직원이 걸리는 시간을 넣는다.
		}

		while (!queue.isEmpty()) {
			int time = queue.poll() + waitSecond;
			if (time > max)
				max = time;
			waitSecond++;
		}

		return dp[clerkIdx] = max;
	}
}

class Clerk {
	ArrayList<Integer> underling = new ArrayList<>(); // 부하직원 인덱스들을 저장
}

// 부하한테 연락을 돌릴때 가장 오래 걸리는 부하부터 돌려야 한다. 그리고 가장 오래걸리는 시간을 반환하는 게 해당 직원의 걸리는 시간
