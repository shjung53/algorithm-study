package 사칙연산유효성검사;

import java.util.*;
import java.io.*;

public class Solution {
	static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			nodes = new Node[n + 1];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				Node node = new Node(num);
				nodes[num] = node;
				String intOrOperator = st.nextToken();
				if (checkOperator(intOrOperator)) {
					node.operator = intOrOperator.charAt(0);
				} else {
					node.value = Integer.parseInt(intOrOperator);
				}
				if (st.hasMoreTokens()) {
					int leftNum = Integer.parseInt(st.nextToken());
					Node leftNode = new Node(leftNum);
					nodes[leftNum] = leftNode;
					node.left = leftNode;
				}

				if (st.hasMoreTokens()) {
					int rightNum = Integer.parseInt(st.nextToken());
					Node rightNode = new Node(rightNum);
					nodes[rightNum] = rightNode;
					node.right = rightNode;
				}

			}
			stb.append("#").append(tc).append(" ").append(check(1)).append("\n");
		}
		System.out.println(stb.toString());
	}

	private static int check(int num) {
		Node node = nodes[num];
		if (node.left == null || node.right == null) {
			if (node.operator != ' ')
				return 0;
			return 1;
		}
		if (check(node.left.num) == 0)
			return 0;
		if (check(node.right.num) == 0)
			return 0;
		return 1;
	}

	private static boolean checkOperator(String str) {
		if (str.length() > 1)
			return false;
		if (!Character.isDigit(str.charAt(0)))
			return true;
		return false;
	}
}

class Node {
	int num;
	int value;
	char operator = ' ';
	Node left;
	Node right;

	Node(int num) {
		this.num = num;
	}

}
