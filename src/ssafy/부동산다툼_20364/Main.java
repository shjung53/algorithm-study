package 부동산다툼_20364;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n; // 땅
	static int q; // 오리
	static boolean[] occupation; // 땅이 점유 되었는지

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		occupation = new boolean[n + 1];

		for (int duck = 1; duck <= q; duck++) {
			int goal = Integer.parseInt(br.readLine().trim());
			int step = 1; // 가는 경로 확인
			boolean canOccupy = true;

			// 경로 모두 확인
			while (step < goal) {
				if (occupation[step]) {
					// 점유된 경우
					canOccupy = false;
					break;
				} else {
					// 점유 안된 경우 다음 땅 찾아가기
					step = next(step, goal);
				}
			}

			// 마지막으로 목표 땅 확인
			if (occupation[step])
				canOccupy = false;

			if (canOccupy) {
				occupation[goal] = true;
				stb.append(0).append('\n');
			} else {
				stb.append(step).append('\n');
			}
		}

		System.out.println(stb.toString());
	}

	// 다음 땅 구하기
	private static int next(int now, int goal) {
		int nextLength = Integer.toBinaryString(now).length() + 1;
		int diff = Integer.toBinaryString(goal).length() - nextLength;
		goal = goal >>= diff; // 이진트리 이전레벨까지 이동

		return goal; // 다음 땅
	}
}
