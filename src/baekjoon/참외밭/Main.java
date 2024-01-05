package 참외밭;

import java.util.*;
import java.io.*;

public class Main {
	static int[] direction = new int[6];
	static int[] distance = new int[6];
	static int longWidthNum = 0;
	static int longHeightNum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int kMelon = Integer.parseInt(br.readLine());
		int big = 0;
		int small =0;

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			direction[i] = dir;
			distance[i] = dis;
		}
		findLong();
		
		if(longHeightNum == 5) {
			if(longWidthNum == 0) {
				small = distance[2] * distance[3];
			}else {
				small = distance[1] * distance[2];
			}
		}
		
		if(longHeightNum == 3) {
			if(longWidthNum == 4) {
				small = distance[0] * distance[1];
			}else {
				small = distance[5] * distance[0];
			}
		}
		
		if(longHeightNum == 1) {
			if(longWidthNum == 2) {
				small = distance[4] * distance[5];
			}else {
				small = distance[3] * distance[4];
			}
		}
		
		big = distance[longHeightNum] * distance[longWidthNum];
		
		int answer = kMelon * (big - small);

		System.out.println(answer);
	}

	private static void findLong() {
		if (distance[0] > distance[2]) {
			longWidthNum = 0;
		} else {
			longWidthNum = 2;
		}

		if (distance[longWidthNum] > distance[4]) {
		} else {
			longWidthNum = 4;
		}

		if (distance[1] > distance[3]) {
			longHeightNum = 1;
		} else {
			longHeightNum = 3;
		}

		if (distance[longHeightNum] > distance[5]) {
		} else {
			longHeightNum = 5;
		}
	}
}
