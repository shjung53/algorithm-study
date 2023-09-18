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

		long count = 0;

//		정렬
		Arrays.sort(students);

//		하나의 값 선택하기 나머지 값에서 투포인터
		for (int i = 0; i < n; i++) {
			int left = i + 1;
			int right = n - 1;

			int goal = students[i] * -1;

			if (students[i] > 0)
				break;

			while (left < right) {
				if (left == i)
					left++;
				if (right == i)
					right--;
				int sum = students[left] + students[right];
//				sum이 더 크면 right--
				if (sum > goal) {
					right--;
//					sum이 더 작으면 left++
				} else if (sum < goal) {
					left++;
				} else {
//					sum == goal인 경우 나오는 상황 두가지로 나누어 경우의 수 계산
//					left와 right의 해당하는 값 같을 때 해당 값 카운트하고  nC2
					if (students[left] == students[right]) {
						long sameCnt = right - left + 1;
						count += (sameCnt * (sameCnt - 1)) / 2;
						break;
					} else {
						long leftCnt = 0;
						long rightCnt = 0;

						int newR = right;
						int newL = left;
						while (students[newR] == students[right]) {
							newR--;
							rightCnt++;
						}
						while (students[newL] == students[left]) {
							newL++;
							leftCnt++;
						}
						right = newR;
						left = newL;
						count += leftCnt * rightCnt;
					}
				}
			}
		}

		System.out.println(count);
	}
}
