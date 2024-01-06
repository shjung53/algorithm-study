package 싫은데요;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] holes = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			holes[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		int size = 0;
//		햄스터 크기보다 작은 최대의 크기
		int answer = Integer.MIN_VALUE;

//		현 포인터 상황 반영
		size += holes[right];
//		사이즈가 햄스터 크기보다 작고 현재 max보다 크면 할당
		if (size <= m && size > answer)
			answer = size;

//		right가 배열을 벗어나면 탈출
		while (right <= n - 1) {
//			사이즈가 햄스터보다 작으면 다음 구멍도 막아보기
			if (size < m) {
				right++;
//				right가 배열을 벗어나면 탈출
				if (right > n - 1)
					break;
//				다음구멍도 막기
				size += holes[right];
			} else {
//				햄스터사이즈보다 막은 구멍의 합이 더 크면 구멍 하나 빼주기 left++
				size -= holes[left];
				left++;
			}
//			총 막은 사이즈가 햄스터보다 같거나 작고 이전까지 크기보다 크면 할당
			if (size <= m && size > answer)
				answer = size;
		}
		
		System.out.println(answer);
	}
}
