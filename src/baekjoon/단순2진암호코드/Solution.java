package 단순2진암호코드;

import java.util.*;
import java.io.*;

public class Solution {
	static String[] code = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder stb = new StringBuilder();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			String secretCode = "";
			boolean start = false;

			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = m - 1; j >= 0; j--) {
					if (!start) {
						if (line.charAt(j) == '1')
							start = true;
					}
					if (!start)
						continue;
					stb.append(line.charAt(j));
					if (secretCode.length() > 7)
						continue;
					if (stb.length() == 7) {
						stb.reverse();
						int check = checkCode(stb.toString());
						stb.setLength(0);;
						if (check == -1)
							continue;
						secretCode += check;
					}
				}
			}

			int oddSum = 0;
			int evenSum = 0;
			int totalSum = 0;
			int answer = 0;

			StringBuffer sb = new StringBuffer(secretCode);
			sb.reverse();
			secretCode = sb.toString();

			for (int i = 0; i < secretCode.length(); i++) {
				if ((i & 1) == 0) {
					oddSum += Character.getNumericValue(secretCode.charAt(i));
					totalSum += Character.getNumericValue(secretCode.charAt(i));
				} else {
					evenSum += Character.getNumericValue(secretCode.charAt(i));
					totalSum += Character.getNumericValue(secretCode.charAt(i));
				}
			}

			if ((oddSum * 3 + evenSum) % 10 == 0)
				answer = totalSum;
			System.out.println(String.format("#%d %d", t, answer));
		}
	}

	private static int checkCode(String str) {
		for (int i = 0; i < 10; i++) {
			if (str.equals(code[i]))
				return i;
		}
		return -1;
	}
}
