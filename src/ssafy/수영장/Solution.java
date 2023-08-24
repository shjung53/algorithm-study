package 수영장;

import java.util.*;
import java.io.*;

public class Solution {
	static int[] use;
	static int min;
	static int day;
	static int month;
	static int threeM;
	static int year;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			use = new int[13];
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());

			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			threeM = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= 12; i++) {
				use[i] = Integer.parseInt(st.nextToken());
			}
			
			calculate(0, 1, 0);
			
			stb.append('#').append(tc).append(' ').append(min).append('\n');
		}
		System.out.println(stb.toString());

	}

	private static void calculate(int using, int index, int money) {
		if (index == 13) {
			min = Math.min(min, money);
			return;
		}
		
		if(using > 0) {
			calculate(using - 1, index + 1, money);
		}else {
			if(use[index] > 0) {
				calculate(using, index + 1, money + day * use[index]);
				calculate(using, index + 1, money + month);
				calculate(using + 2, index + 1, money + threeM);
				calculate(using + 11, index + 1, money + year);
			}else {
				calculate(using, index + 1, money);
			}
		}
		
	}
}
