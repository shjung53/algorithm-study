import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static int n;
	static int m;
	static int answer;

	static int[] oneX = { 0, 1, 2, 3 };
	static int[] oneY = { 0, 0, 0, 0 };
	static int[] twoX = { 0, 1, 0, 1 };
	static int[] twoY = { 0, 0, 1, 1 };
	static int[] threeX = { 0, 0, 0, 1 };
	static int[] threeY = { 0, 1, 2, 2 };
	static int[] fourX = { 0, 0, 1, 1 };
	static int[] fourY = { 0, 1, 1, 2 };
	static int[] fiveX = { 0, 0, -1, 1 };
	static int[] fiveY = { 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		answer = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// 1번 부터 5번 도형 다 넣어보기

				// 1번 가로
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int newY = i + oneY[k];
					int newX = j + oneX[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}

				// 1번 세로
				for (int k = 0; k < 4; k++) {
					int newY = i + oneX[k];
					int newX = j + oneY[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}

				// 2번
				for (int k = 0; k < 4; k++) {
					int newY = i + twoY[k];
					int newX = j + twoX[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}

				// 3번은 4방향 모두와 대칭까지 8가지가 존재
				// 3번 세로
				for (int k = 0; k < 4; k++) {
					int newY = i + threeY[k];
					int newX = j + threeX[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				for (int k = 0; k < 4; k++) {
					int newY = i + threeY[k];
					int newX = j + threeX[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				// 3번 세로
				for (int k = 0; k < 4; k++) {
					int newY = i + threeY[k] * -1;
					int newX = j + threeX[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				// 3번 세로
				for (int k = 0; k < 4; k++) {
					int newY = i + threeY[k] * -1;
					int newX = j + threeX[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}

				// 3번 가로
				for (int k = 0; k < 4; k++) {
					int newY = i + threeX[k];
					int newX = j + threeY[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				for (int k = 0; k < 4; k++) {
					int newY = i + threeX[k] * -1;
					int newX = j + threeY[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				// 3번 가로
				for (int k = 0; k < 4; k++) {
					int newY = i + threeX[k] * -1;
					int newX = j + threeY[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				// 3번 가로
				for (int k = 0; k < 4; k++) {
					int newY = i + threeX[k];
					int newX = j + threeY[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				//4번 세로
				for (int k = 0; k < 4; k++) {
					int newY = i + fourY[k];
					int newX = j + fourX[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				//4번 세로
				for (int k = 0; k < 4; k++) {
					int newY = i + fourY[k];
					int newX = j + fourX[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				//4번 세로
				for (int k = 0; k < 4; k++) {
					int newY = i + fourY[k] * -1;
					int newX = j + fourX[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				//4번 세로
				for (int k = 0; k < 4; k++) {
					int newY = i + fourY[k] * -1;
					int newX = j + fourX[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				
				//4번 가로
				for (int k = 0; k < 4; k++) {
					int newY = i + fourX[k];
					int newX = j + fourY[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				//4번 가로
				for (int k = 0; k < 4; k++) {
					int newY = i + fourX[k] * -1;
					int newX = j + fourY[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				for (int k = 0; k < 4; k++) {
					int newY = i + fourX[k] * -1;
					int newX = j + fourY[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				for (int k = 0; k < 4; k++) {
					int newY = i + fourX[k];
					int newX = j + fourY[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				
				// 5번 
				for (int k = 0; k < 4; k++) {
					int newY = i + fiveY[k];
					int newX = j + fiveX[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				// 5번 
				for (int k = 0; k < 4; k++) {
					int newY = i + fiveY[k] * -1;
					int newX = j + fiveX[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				// 5번 
				for (int k = 0; k < 4; k++) {
					int newY = i + fiveX[k];
					int newX = j + fiveY[k];
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
				
				// 5번 
				for (int k = 0; k < 4; k++) {
					int newY = i + fiveX[k] * -1;
					int newX = j + fiveY[k] * -1;
					// 넘어가면 아예 도형을 볼 필요가 없어짐
					if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
						count = 0;
						break;
					}

					count += board[newY][newX];
					// 도형 다 돌았으면 최댓값 확인하고 초기화
					if (k == 3) {
						if (count > answer)
							answer = count;
						count = 0;
					}
				}
			}
		}

		System.out.println(answer);

	}
}
