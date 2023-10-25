package 이가빠진이진트리_26260;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static Node[] nodes;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());

		nodes = new Node[n + 1];
		int erasedIdx = 0;

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 1; i <= n; i++) {
			int value = Integer.parseInt(st.nextToken());
			nodes[i].parent = i / 2;
			nodes[i].left = i * 2;
			nodes[i].right = i * 2 + 1;
			nodes[i].value = value;
			if (value == -1)
				erasedIdx = i;
		}

		int checkIdx = erasedIdx;
		nodes[erasedIdx].value = Integer.parseInt(br.readLine().trim());

		while (true) {
			// 리프 노드 조건: idx가 2로 나눈 값보다 크면 트리의 마지막 레벨 - 자식이 없음
			if (checkIdx > n / 2) {
				// 홀수면 오른쪽 자식
				if ((checkIdx & 1) == 1) {
					if(nodes[checkIdx].value > nodes[checkIdx / 2].value) break;
				} else {

				}
			}
		}
	}
}

class Node {
	int value, parent, left, right;

	public Node(int value) {
		super();
		this.value = value;
	}
}
