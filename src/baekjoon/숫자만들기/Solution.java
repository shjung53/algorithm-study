package 숫자만들기;

import java.util.*;
import java.io.*;

public class Solution {

//	0부터 +, -, *, / 의 개수, 테케마다 초기화됨
	static int[] operator = new int[4];
	static int[] nums;
	static int n;
	static int max;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
//			연산자 갯수 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				operator[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < n; k++) {
				nums[k] = Integer.parseInt(st.nextToken());
			}

			cal(1, nums[0]);

			int answer = max - min;
			stb.append('#').append(t).append(' ').append(answer).append('\n');
		}

		System.out.println(stb.toString());

	}

	private static void cal(int index, int result) {
		if (index == n) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				switch (i) {
				case 0:
					operator[i]--;
					cal(index + 1, result + nums[index]);
					operator[i]++;
					break;
				case 1:
					operator[i]--;
					cal(index + 1, result - nums[index]);
					operator[i]++;
					break;
				case 2:
					operator[i]--;
					cal(index + 1, result * nums[index]);
					operator[i]++;
					break;
				case 3:
					operator[i]--;
					cal(index + 1, result / nums[index]);
					operator[i]++;
					break;
				}
			}
		}

	}
}