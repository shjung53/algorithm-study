package 좋다;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int count = 0;

		for (int i = 0; i < n; i++) {
			int target = arr[i];

			int left = 0;
			int right = 1;

//			자기 자신이면 패스
			if (left == i) {
				left++;
				right++;
			}

//			자기 자신이면 패스
			if (right == i) {
				right++;
			}

//			초기 값
			int sum = arr[left] + arr[right];

			while (left < n - 1 && right < n) {
				if (sum < target) {
					sum -= arr[right];
					right++;
//					자기자신이면 right++
					if (right == i)
						right++;
//					배열넘어가면 left++
					if (right >= n) {
						sum -= arr[left];
						left++;
						sum += arr[left];
						right = left + 1;
					}
					if (left == i) {
						sum -= arr[left];
						left++;
						sum += arr[left];
						right++;
					}
					if (right == i)
						right++;

					if (right >= n)
						continue;

					sum += arr[right];

				} else if (sum > target) {
					sum = 0;
					left++;
					if (left == i)
						left++;
					right = left + 1;
					if (right == i)
						right++;
					if (right >= n)
						continue;
					sum = arr[left] + arr[right];
				} else {
					count++;
					break;
				}
			}
		}

		System.out.println(count);
	}
}
