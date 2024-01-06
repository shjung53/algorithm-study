package 겹치는건싫어_20922;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];

//		숫자 카운팅을 위한 배열
		int[] count = new int[100001];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int length = 0;
		int left = 0;
		int right = 0;
		int answer = Integer.MIN_VALUE;

//		현재 포인터 상황 반영
		count[arr[right]]++;
		length++;

//		right가 배열을 벗어나면 탈출
		while (right <= n - 1) {
			right++;
//			right가 배열을 벗어나면 탈출
			if (right > n - 1)
				break;
			count[arr[right]]++;
			length++;
			if (count[arr[right]] > k) {
				while (count[arr[right]] > k) {
					count[arr[left]]--;
					left++;
					length--;
				}
			}

			if (length > answer)
				answer = length;

		}

		System.out.println(answer);
	}
}
