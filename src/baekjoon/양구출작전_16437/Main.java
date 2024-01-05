package 양구출작전_16437;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static Land[] lands;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		lands = new Land[n + 1];

		// 땅 초기화
		for (int idx = 0; idx <= n; idx++) {
			lands[idx] = new Land(idx);
		}

		// 땅 세팅
		for (int idx = 2; idx <= n; idx++) {
			st = new StringTokenizer(br.readLine().trim());
			String kind = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			int linkTo = Integer.parseInt(st.nextToken());
			lands[idx].kind = kind;
			if (kind.equals("W")) {
				lands[idx].w = count;
			} else {
				lands[idx].s = count;
			}
			lands[linkTo].linkFrom.add(idx);
			lands[idx].linkTo = linkTo;
		}

		Queue<Integer> queue = new ArrayDeque<>();

		for (int idx = 2; idx <= n; idx++) {
			if (lands[idx].linkFrom.size() < 1) {
				queue.offer(idx);
			}
		}

		while (!queue.isEmpty()) {
			int queueSize = queue.size();

			for (int i = 0; i < queueSize; i++) {
				int now = queue.poll();
				if (now == 1)
					break;
				if (lands[now].kind.equals("W")) {
					if (lands[now].s >= lands[now].w) {
						lands[now].s -= lands[now].w;
						lands[now].w = 0;
					} else {
						lands[now].w -= lands[now].s;
						lands[now].s = 0;
					}
				}
				lands[lands[now].linkTo].s += lands[now].s;
				lands[lands[now].linkTo].linkFrom.remove(lands[now].idx);
				if (lands[lands[now].linkTo].linkFrom.size() < 1) {
					queue.offer(lands[now].linkTo);
				}
			}
		}

		System.out.println(lands[1].s);
	}
}

class Land {
	int idx;
	String kind;
	int w;
	long s;
	HashSet<Integer> linkFrom;
	int linkTo;

	public Land(int idx) {
		super();
		this.idx = idx;
		this.linkFrom = new HashSet<Integer>();
	}

}
