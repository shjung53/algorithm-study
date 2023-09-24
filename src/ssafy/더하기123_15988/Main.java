package 더하기123_15988;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static Long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		arr = new Long[1000001];
		for (int tc = 1; tc <= testCase; tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(findNum(n));
		}
	}

	// 1,2,3으로만 표현되기 때문에 자기 인덱스의 -3인 수의 모든 경우의 수에 3만 더해주고 -2인 수의 경우에 수에는 2만 -1인 경우의
	// 수에 1만 더해주면 자기의 경우의 수가 나온다.
	// 머리가 좋아야 푸는 문제들이다 dp는.. 나는 못풀겠다
	// 재귀로 하면 스택 오버플로가 난다. 반복문으로 풀어야 한다.
	static private long findNum(int index) {
		for (int i = 1; i <= index; i++) {
			if (i == 1)
				arr[i] = 1L;
			if (i == 2)
				arr[i] = 2L;
			if (i == 3)
				arr[i] = 4L;
			if (arr[i] == null) {
				arr[i] = (arr[i - 3] + arr[i - 2] + arr[i - 1]) % 1000000009;
			}
		}
		return arr[index];
	}
}
