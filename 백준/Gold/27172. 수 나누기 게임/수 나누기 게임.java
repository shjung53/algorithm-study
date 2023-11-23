import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] numbers;
	static int[] points;
	static int max = 0;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());

		numbers = new int[n + 1];
		points = new int[n + 1];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			if (numbers[i] > max)
				max = numbers[i];
		}

		// 인덱스가 숫자, 값은 번호
		arr = new int[max + 1];

		for (int i = 1; i <= n; i++) {
			arr[numbers[i]] = i;
		}

		for (int i = 1; i <= n; i++) {
			int index = numbers[i];

			while (index <= max) {
				
				// 배수에 위치한 숫자가 0보다 크면 나눌 수 있기 때문에 점수를 얻는다.
				if (arr[index] > 0) {
					points[i]++;
					points[arr[index]]--;
				}
				
				index += numbers[i]; // 다음 배수로 이동
			}
		}

		StringBuilder stb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			stb.append(points[i]).append(' ');
		}

		System.out.println(stb);
	}
}
