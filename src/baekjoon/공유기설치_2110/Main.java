package 공유기설치_2110;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] house = new int[n];
		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
//		정렬
		Arrays.sort(house);

//		처음 집에 공유기 설치 후 시작 -> 어차피 최대가 되려면 처음과 마지막 집엔 공유기가 설치되어야 함
		int start = 1;
		int end = house[n - 1] - house[0];

		while (start <= end) {

			int mid = (start + end) / 2;

			int count = 1;
			int pre = house[0];

			for (int i = 1; i < n; i++) {
//				공유기 다 설치하면 탈출
				if(count >= c) break;
//				이번 집이 이전집과의 거리가 설정한 최소거리보다 작으면 패스
				if(house[i] - pre < mid) continue;
				count++;
				pre = house[i];
			}
			
//			공유기 다 설치못했으면 거리 줄이고 설치했으면 거리 늘려서 다시 트라이
			if(count < c) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		System.out.println(end);

	}
}
