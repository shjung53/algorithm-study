package 회의실배정;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int meetingCount;
	static int nowTime; // 미팅이 끝난후 현재 시간
	static int answer; // 진행하는 미팅 개수

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		meetingCount = Integer.parseInt(br.readLine().trim());

		// 끝나는 시간이 더 빠른 순서대로 회의 정렬, 끝나는 시간이 같으면 시작시간이 더 빠른 순서대로
		PriorityQueue<Meeting> queue = new PriorityQueue<Meeting>(1, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				if (o1.end == o2.end) {
					return o1.start - o2.start;
				} else {
					return o1.end - o2.end;
				}
			}
		});

		for (int i = 0; i < meetingCount; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			queue.offer(new Meeting(start, end));
		}

		nowTime = 0;

		// 현재 시간이 가장 빨리 끝나는 시간보다 커지면 진행할 수 있는 미팅이 더이상 없다.
		while (!queue.isEmpty() && nowTime <= queue.peek().end) {
			Meeting meeting = queue.poll();
			// 시작시간이 현재시간보다 같거나 크면 진행가능
			if (nowTime <= meeting.start) {
				// 현재 시간을 끝나는 시간으롭 변경하고 미팅 진행한 횟수 추가
				nowTime = meeting.end;
				answer++;
			}
		}

		System.out.println(answer);
	}
}

class Meeting {
	int start;
	int end;

	public Meeting(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

}
