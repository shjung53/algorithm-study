package 강의실_1374;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static Meeting[] meetings;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());

		meetings = new Meeting[n];

		// 빨리 끝나는 순서로 정렬,
		PriorityQueue<Meeting> queue = new PriorityQueue<Meeting>(1, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				return o1.end - o2.end;
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(num, start, end);
		}

		// 빨리 시작하는 순서로 정렬
		Arrays.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});

		queue.offer(meetings[0]);

		answer = queue.size();

		// 시작시간이 빠른 순서로 강의들을 확인하면서, 가장 빨리 끝나는 강의실을 이어서 사용할 수 있는지 확인하기
		for (int i = 1; i < n; i++) {
			if (meetings[i].start < queue.peek().end) {
				queue.offer(meetings[i]);
			} else {
				queue.poll();
				queue.offer(meetings[i]);
			}

			if (queue.size() > answer)
				answer = queue.size();

		}

		System.out.println(answer);

	}
}

class Meeting {
	int num;
	int start;
	int end;

	public Meeting(int num, int start, int end) {
		super();
		this.num = num;
		this.start = start;
		this.end = end;
	}

}
