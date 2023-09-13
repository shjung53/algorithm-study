package 합이0;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] students = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

//		정렬
		Arrays.sort(students);

//		하나의 값 선택하기 나머지 값에서 투포인터
		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = left + 1;

			if (students[i] + students[n - 2] + students[n - 1] < 0)
				continue;

			while (right < n) {
				int sum = students[i];

				sum += students[left];
				sum += students[right];

				if (students[i] + students[left] + students[n - 1] < 0) {
					left++;
					right = n - 1;
					continue;
				}

//				합이 0이면 추가
				if (sum == 0)
					count++;

//				0보다 같거나 작으면 right이동(코딩실력이 같은 학생이 있을 수 있음)
				if (sum <= 0) {
					right++;
					if (right >= n) {
						left++;
						right = n - 1;
					}
				}
//				정렬되어 있으므로 합이 0보다 크면 left 이동
				if (sum > 0) {
					left++;
					right = left + 1;
				}

			}
		}

		System.out.println(count);
	}
}
