package 같이눈사람만들래;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] balls = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			balls[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(balls);
		int answer = Integer.MAX_VALUE;

		Loop: for (int i = 0; i < n - 3; i++) {
			for (int j = n - 1; j >= i + 3; j--) {
//				비교 대상 눈사람 만들기
				int check = balls[i] + balls[j];

//				겹치면 left++
				int left = i + 1;
				int right = j - 1;

				while (left < right) {
					int sum = balls[left] + balls[right];

					int gap = Math.abs(check - sum);

					if (answer > gap)
						answer = gap;

					if (sum > check) {
						right--;
					} else if (sum < check) {
						left++;
					} else {
//						아예 같으면 빠져나오기
						answer = 0;
						break Loop;
					}
				}

			}
		}

		System.out.println(answer);
	}
}
