package 개똥벌레_3020;

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int h;
	static int[] down;
	static int[] up;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		down = new int[n / 2];
		up = new int[n / 2];
		for (int i = 0; i < n / 2; i++) {
			down[i] = Integer.parseInt(br.readLine());
			up[i] = Integer.parseInt(br.readLine());
		}

//		석순과 종유석 구분
		Arrays.sort(down);
		Arrays.sort(up);

		int min = n;
		int minCount = 0;

		for (int i = 1; i <= h; i++) {
//			석순과 종유석 따로 구하기, h - i + 1 -> i가 최대 높이 h일때 0이 아닌 1이어야 한다.
			int count = countWall(i, down) + countWall(h - i + 1, up);

//			부순 벽 수가 최솟값이면 카운트
			if (min == count)
				minCount++;

//			부순 벽 수가 최솟값보다 작으면 갱신
			if (count < min) {
				min = count;
				minCount = 1;
			}
		}

		System.out.println("" + min + " " + minCount);

	}

//	이분탐색으로 빠르게 벽의 개수 구하기
	private static int countWall(int height, int[] arr) {
		int start = 0;
		int end = n / 2  - 1;
		
//		현재 높이에 닿는 최솟값 찾아서 닿는 개수 구하기
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= height) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return n / 2 - start;

	}
}
