package 친구_1058;

import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new char[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
//			같은 친구 중복 추가 방지
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'Y') {
//					1-친구 추가
					set.add(j);
//					돌면서 2-친구 추가
					for (int k = 0; k < n; k++) {
//						친구의 친구가 자기인 경우 빼고 추가
						if (board[j][k] == 'Y' && k != i) {
							set.add(k);
						}
					}
				}
			}
			int friends = set.size();
			if (friends > answer)
				answer = friends;
		}

		System.out.println(answer);

	}
}
