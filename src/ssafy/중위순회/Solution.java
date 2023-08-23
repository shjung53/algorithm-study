package 중위순회;

import java.util.*;
import java.io.*;

public class Solution {
	static String answer = "";
	static Node[] nodes;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			nodes = new Node[n + 1];
			answer = "";
			visited = new boolean[n + 1];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				String[] strArr = str.split(" ");

				int num = Integer.parseInt(strArr[0]);
				String c = strArr[1];

				Node node;

				if (nodes[num] == null) {
					node = new Node(num, c);
					nodes[num] = node;
				} else {
					node = nodes[num];
					node.c = c;
				}

				if (strArr.length > 2) {
					int leftNum = Integer.parseInt(strArr[2]);
					Node leftNode = new Node(leftNum);
					nodes[leftNum] = leftNode;
					node.left = leftNode;
				}

				if (strArr.length > 3) {
					int rightNum = Integer.parseInt(strArr[3]);
					Node rightNode = new Node(rightNum);
					nodes[rightNum] = rightNode;
					node.right = rightNode;
				}
			}
			
			completeAnswer(1);
			
			stb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(stb.toString());
	}

	private static void completeAnswer(int num) {
		Node node = nodes[num];
		if (node.left != null) {
			if (!visited[node.left.num]) {
				completeAnswer(node.left.num);
			}
		}
		
		if(!visited[num]) {
			answer += node.c;
			visited[num] = true;
		}
		
		if(node.right != null) {
			if(!visited[node.right.num]) {
				completeAnswer(node.right.num);
			}
		}
	}

}

class Node {
	int num;
	String c;
	Node left;
	Node right;

	Node(int num) {
		this.num = num;
	}

	Node(int num, String c) {
		this.num = num;
		this.c = c;
	}
}