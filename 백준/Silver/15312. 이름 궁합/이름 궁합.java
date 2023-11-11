import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;

	static int[] alpha = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		arr = new int[a.length() + b.length()][a.length() + b.length()];

		// 첫 행에 글자 획수 저장
		for (int i = 0; i < a.length() + b.length(); i += 2) {
			arr[0][i] = alpha[a.charAt(i / 2) - 'A'];
			arr[0][i + 1] = alpha[b.charAt(i / 2) - 'A'];
		}

		// 바로 이전 행 자기 (인덱스의 수 + 다음 인덱스의 수) % 10
		for (int i = 1; i < a.length() + b.length(); i++) {
			for (int j = 0; j < a.length() + b.length() - i; j++) {
				arr[i][j] = (arr[i - 1][j] + arr[i - 1][j + 1]) % 10;
			}
		}

		String answer = "" + arr[a.length() + b.length() - 2][0] + arr[a.length() + b.length() - 2][1];
		System.out.println(answer);
	}
}
