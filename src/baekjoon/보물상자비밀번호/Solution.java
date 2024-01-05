package 보물상자비밀번호;

import java.util.*;
import java.io.*;

public class Solution {
	static int[] hexValue = { 10, 11, 12, 13, 14, 15 };
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int k;
	static String nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder stb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			nums = br.readLine().trim();

			Set<String> set = new HashSet<>();
			TreeSet<Long> tree = new TreeSet<>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j += n / 4) {
					// 4로 나누어서 중복없이 저장하기
					set.add(nums.substring(j, j + n / 4));
				}
				nums = nums.charAt(nums.length() - 1) + nums.substring(0, nums.length() - 1);
			}

			// set에서 문자열을 꺼내서 16진수를 10진수로 바꾸어서 treeSet에 넣기
			for (String s : set) {
				tree.add(hexToTen(s));
			}

			long answer = 0;

			// 큰순서대로 k번째 수 정답
			for (int i = 0; i < k; i++) {
				answer = tree.pollLast();
			}

			stb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static long hexToTen(String hex) {
		int multi = 1;
		int index = hex.length() - 1;
		long result = 0;

		while (index >= 0) {
			if (Character.isAlphabetic(hex.charAt(index))) {
				result += multi * hexValue[(hex.charAt(index) - 'A')];
			} else {
				result += multi * Character.getNumericValue(hex.charAt(index));
			}
			multi *= 16;
			index--;
		}

		return result;

	}
}
