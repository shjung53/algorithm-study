import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int number;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		number = Integer.parseInt(br.readLine().trim());
		dp = new int[1000001];

		dp[3] = 1;
		dp[2] = 1;

		findDp(number);

		System.out.println(dp[number]);

	}

	private static int findDp(int num) {
		if (num == 1)
			return 0;
		if (dp[num] > 0)
			return dp[num];

		int min = num - 1; // 위에서 조건을 한번 거르기 때문에 무조건 존재하는 num - 1로 초기화, 바로 직전의 값 중 최소 연산을 가지는 수

		if (num % 3 == 0) {
			if (findDp(num / 3) < findDp(min))
				min = num / 3;
		}

		if (num % 2 == 0) {
			if (findDp(num / 2) < findDp(min))
				min = num / 2;
		}

		return dp[num] = findDp(min) + 1;

	}
}
