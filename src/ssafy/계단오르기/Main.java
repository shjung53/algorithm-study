package 계단오르기;

import java.util.*;
import java.io.*;

public class Main {
<<<<<<< HEAD
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int stairCount = Integer.parseInt(br.readLine().trim());

		int[] stairArr = new int[stairCount];
		int[] point = new int[stairCount];

		for (int i = 0; i < stairCount; i++) {
			stairArr[i] = Integer.parseInt(br.readLine().trim());
		}

		for (int i = stairCount - 1; i >= 2; i--) {
			point[i] = Math.max(point[i - 1] + stairArr[i], point[i - 2] + stairArr[i]);
		}

		System.out.println(point[point.length - 1]);
=======
	static BufferedReader br;
	static StringTokenizer st;
	static Integer[] point;
	static Integer[] stair;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		stair = new Integer[n];
		point = new Integer[n];

		for (int i = 0; i < n; i++) {
			point[i] = Integer.parseInt(br.readLine());
		}

		int answer = stair[n - 1] = find(n - 1);
		System.out.println(answer);
	}

	private static int find(int index) {
		// index가 0보다 작으면 시작점이다.
		if (index < 0)
			return 0;
		// 첫 계단은 첫 계단의 점수만 가질 수 있다.
		if (index == 0)
			return stair[index] = point[index];

		// 계단의 최댓값이 정해지지 않으면 구해야 한다.
		if (stair[index] == null) {
			// 계단은 바로 전 계단에서 오거나 2칸전 계단에서 온다.
			// 바로 전 계단에서 오는 경우 바로 전 계단이 그 바로 전 계단에서 오지 않는 걸 보장해야 한다.
			return stair[index] = Math.max(find(index - 3) + point[index - 1] + point[index],
					find(index - 2) + point[index]);
		} else {
			return stair[index];
		}
>>>>>>> a7e869312b8da14202a942b742f553c35dd1c29d

	}
}
