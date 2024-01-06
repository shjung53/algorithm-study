package 암호코드스캔;

import java.util.*;
import java.io.*;

public class Solution {
	static String[] code = { "3211", "2221", "2122", "1411", "1132", "1231", "1114", "1312", "1213", "3112" };
	static String[] hex = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010",
			"1011", "1100", "1101", "1110", "1111" };
	static int devide = 0;

	static int[] makeCode = new int[4];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder stb = new StringBuilder();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			ArrayList<String> secretCodes = new ArrayList<>();
			makeCode = new int[4];

			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				devide = Integer.MAX_VALUE;
				boolean start = false;

				String secretCode = "";
//				이진수로 변환
				for (int j = 0; j < m; j++) {
					stb.append(hex[toBinary(line.charAt(j))]);
				}

//				비율확인
				char pre = '0';
				int count = 0;
				int codeCount = 3;
				String binary = stb.toString();
				stb = new StringBuilder();
				int length = binary.length();
				for (int j = length - 1; j >= 0; j--) {
//					1이 한번이라도 나와야 카운트 시작
					if (!start) {
						if (binary.charAt(j) == '1') {
							start = true;
							pre = '1';
							count = 1;
							continue;
						}
						continue;
					}

//					1이 나온 이후로는 바뀌기 전까지 카운트, 바뀌면 카운트 더하기 
					if (binary.charAt(j) == pre && j != 0) {
						count++;
					} else {
						if (pre == '1') {
							pre = '0';
						} else {
							pre = '1';
						}

						if (codeCount == 0) {
							for (int k = 3; k >= 1; k--) {
								if (devide > makeCode[k])
									devide = makeCode[k];
							}
						}

						if (codeCount == 0) {
							count = devide * 7;
							for (int k = 3; k >= 1; k--) {
								count -= makeCode[k];
							}
						}

						makeCode[codeCount] = count;
						codeCount--;

						count = 1;
//						4자리 나왔으면 secretCode에 makeCode로 숫자구해서 넣기
						if (codeCount == -1) {
							secretCode = checkCode(toCode()) + secretCode;
							makeCode = new int[4];
							codeCount = 3;
						}
						
						if (secretCode.length() == 8) {
							count = 1;
							if (!secretCodes.contains(secretCode))
								secretCodes.add(secretCode);
							secretCode = "";
							devide = Integer.MAX_VALUE;
						}
					}

				}
			}
			int answer = 0;

			for (String str : secretCodes) {
				int oddSum = 0;
				int evenSum = 0;
				int totalSum = 0;
				int check = Character.getNumericValue(str.charAt(7));

				for (int i = 0; i < 7; i++) {
					if ((i & 1) == 0) {
						oddSum += Character.getNumericValue(str.charAt(i));
						totalSum += Character.getNumericValue(str.charAt(i));
					} else {
						evenSum += Character.getNumericValue(str.charAt(i));
						totalSum += Character.getNumericValue(str.charAt(i));
					}
				}

				if ((oddSum * 3 + evenSum + check) % 10 == 0)
					answer += totalSum + check;
			}
			System.out.println(String.format("#%d %d", t, answer));
		}
	}

	private static int toBinary(char c) {
		if (Character.isDigit(c)) {
			return Character.getNumericValue(c);
		} else {
			switch (c) {
			case 'A':
				return 10;
			case 'B':
				return 11;
			case 'C':
				return 12;
			case 'D':
				return 13;
			case 'E':
				return 14;
			case 'F':
				return 15;
			}
		}
		return -1;
	}

	private static String toCode() {
		String str = "";

		for (int i = 0; i < 4; i++) {
			str += makeCode[i] / devide;
		}

		return str;
	}

	private static int checkCode(String str) {
		for (int i = 0; i < 10; i++) {
			if (str.equals(code[i]))
				return i;
		}
		return -1;
	}
}
