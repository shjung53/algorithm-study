package 귀여운라이언_15565;

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

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		int count = 0;
		int length = 0;
		int answer = Integer.MAX_VALUE;
		
//		포인터의 현상황 반영
		if(arr[right] == 1) count++;
		length++;

//		right가 배열을 벗어나면 끝
		while (right <= n - 1) {
//			라이언 인형 갯수가 충분하지 않으면 right 이동, 충분하면 left이동하면서 원래 바라보던 인형이 라이언이면 count--
			if (count < k) {
				right++;
//				right가 배열을 벗어나면 끝
				if(right > n-1) break;
//				right가 유효한 배열일때만 length++, 라이언 인형이면 count++
				length++;
				if(arr[right] == 1) count++;
			} else {
				if (arr[left] == 1)
					count--;
				left++;
				length--;
			}
			
			if(count < k) continue;
			if(length < answer) answer = length;
		}
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);

	}
}
