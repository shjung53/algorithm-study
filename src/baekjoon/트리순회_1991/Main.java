package 트리순회_1991;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static Node[] nodes;
	static int n;
	static StringBuilder stb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		stb = new StringBuilder();
		nodes = new Node[26];

		for (int i = 0; i < 26; i++) {
			nodes[i] = new Node();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			char now = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			nodes[now - 'A'].left = left;
			nodes[now - 'A'].right = right;
		}

		preOrder('A');
		stb.append('\n');
		inOrder('A');
		stb.append('\n');
		postOrder('A');
		System.out.println(stb.toString());

	}

	private static void preOrder(char c) {
		stb.append(c);
		if (nodes[c - 'A'].left != '.') {
			preOrder(nodes[c - 'A'].left);
		}

		if (nodes[c - 'A'].right != '.') {
			preOrder(nodes[c - 'A'].right);
		}
	}

	private static void inOrder(char c) {
		// 왼쪽 자식이 있으면 왼쪽으로 내려가
		if (nodes[c - 'A'].left != '.') {
			inOrder(nodes[c - 'A'].left);
		}
		// 왼쪽을 찍은 후엔 자기 찍기
		stb.append(c);

		// 그 다음에 오른쪽 내려가보기
		if (nodes[c - 'A'].right != '.') {
			inOrder(nodes[c - 'A'].right);
		}
	}

	private static void postOrder(char c) {
		// 왼쪽 자식이 있으면 왼쪽으로 내려가
		if (nodes[c - 'A'].left != '.') {
			postOrder(nodes[c - 'A'].left);
		}

		// 그 다음에 오른쪽 내려가보기
		if (nodes[c - 'A'].right != '.') {
			postOrder(nodes[c - 'A'].right);
		}

		// 그다음 자기 찍기
		stb.append(c);
	}
}

class Node {
	char parent, left, right;
}
