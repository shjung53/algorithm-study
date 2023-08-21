package 회문1;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			char[][] board = new char[8][8];
			int line = Integer.parseInt(br.readLine());
			int answer = 0;

			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (j + line - 1 < 8) {
						String str = "";
						for (int k = 0; k < line; k++) {
							str += board[i][j + k];
						}
						if (checkPalindrome(str)) answer++;
					}

					if (i + line - 1 < 8) {
						String str = "";
						for (int k = 0; k < line; k++) {
							str += board[i + k][j];
						}
						if (checkPalindrome(str)) answer++;
					}
				}
			}
			stb.append('#').append(t).append(' ').append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static boolean checkPalindrome(String str) {
		boolean palindrome = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				palindrome = false;
				break;
			}
		}

		return palindrome;
	}
}
