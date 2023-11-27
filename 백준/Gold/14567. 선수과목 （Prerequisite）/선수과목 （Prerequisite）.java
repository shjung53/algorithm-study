import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static Lecture[] lectures;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 강의들 초기화
		lectures = new Lecture[n + 1];
		for (int i = 1; i <= n; i++) {
			lectures[i] = new Lecture();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lectures[b].preLectures.add(a);
			lectures[a].postLectures.add(b);
		}

		Queue<Integer> queue = new ArrayDeque<>(); // 강의 번호로 제어

		for (int i = 1; i <= n; i++) {
			if (lectures[i].preLectures.size() == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int lecture = queue.poll(); // 강의 뽑기
			for (int postLecture : lectures[lecture].postLectures) {
				if (postLecture == 0)
					continue; // 다른 과목의 선수과목이 아니면 패스
				lectures[postLecture].preLectures.remove(lecture); // 현재 과목을 수강처리
				if (lectures[postLecture].preLectures.size() == 0) {
					lectures[postLecture].semester = lectures[lecture].semester + 1;
					queue.offer(postLecture);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			stb.append(lectures[i].semester).append(' ');
		}
		System.out.println(stb);
	}
}

class Lecture {
	int semester = 1;
	Set<Integer> postLectures = new HashSet<Integer>();
	Set<Integer> preLectures = new HashSet<Integer>();
}
