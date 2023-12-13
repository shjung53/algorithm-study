import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		for (int tc = 1; tc <= test; tc++) {
			boolean reverse = false; // 정방향인지 아닌지
			boolean error = false; // 에러발생 확인
			String functions = br.readLine().trim(); // 함수 문자열
			int n = Integer.parseInt(br.readLine().trim()); // 배열 크기
			ArrayDeque<Integer> deque = new ArrayDeque<Integer>(); // 함수를 다룰 덱
			String str = br.readLine().trim();
			String[] strArr = str.substring(1, str.length() - 1).split(",");

			// 숫자 배열 할당
			for (int i = 0; i < n; i++) {
				deque.addLast(Integer.parseInt(strArr[i]));
			}

			for (char c : functions.toCharArray()) {
				// R이면 뒤집기
				if (c == 'R') {
					reverse = !reverse;
				}

				// D면 방향에 맞게 삭제
				if (c == 'D') {
					// 비었는데 삭제하면 에러 발생
					if (deque.isEmpty()) {
						error = true;
						break;
					}
					if (reverse) {
						deque.removeLast();
					} else {
						deque.removeFirst();
					}
				}
			}

			if (error) {
				// 에러 발생했으면 에러 넣고 다음 테스트케이스로 이동
				stb.append("error").append('\n');
				continue;
			}

			// 방향에 맞게 배열 stringbuilder에 넣기
			int dequeSize = deque.size();
			stb.append('[');
			if (reverse) {
				while (!deque.isEmpty()) {
					stb.append(deque.removeLast()).append(',');
				}
			} else {
				while (!deque.isEmpty()) {
					stb.append(deque.removeFirst()).append(',');
				}
			}
			if (dequeSize > 0)
				stb.deleteCharAt(stb.length() - 1);
			stb.append(']').append('\n');
		}
		System.out.println(stb);
	}
}
