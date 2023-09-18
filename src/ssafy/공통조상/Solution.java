package 공통조상;

import java.util.*;
import java.io.*;

public class Solution {
	static int v;
	static int e;
	static Node[] arr;
	static int level;
	static int count;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int root = 0;

			arr = new Node[v + 1];

			for (int i = 1; i <= v; i++) {
				arr[i] = new Node(i);
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < e; i++) {
				int parentIndex = Integer.parseInt(st.nextToken());
				int childIndex = Integer.parseInt(st.nextToken());
				if (arr[parentIndex].left > 0) {
					arr[parentIndex].right = childIndex;
				} else {
					arr[parentIndex].left = childIndex;
				}
				arr[childIndex].parent = parentIndex;
			}

			for (int i = 1; i <= v + 1; i++) {
				if (arr[i].parent == 0) {
					root = i;
					break;
				}
			}

			level = 0;
			dfs(root);

			int pA = a;
			int pB = b;

			while (arr[pA].depth != arr[pB].depth) {
				if (arr[pA].depth > arr[pB].depth) {
					pA = arr[pA].parent;
				} else {
					pB = arr[pB].parent;
				}
			}

			while (pA != pB) {
				pA = arr[pA].parent;
				pB = arr[pB].parent;
			}

			count = 1;
			answer = 0;
			count(pA);

			stb.append('#').append(tc).append(' ').append(pA).append(' ').append(answer).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void count(int index) {
		if (count > answer)
			answer = count;
		if (arr[index].left > 0) {
			count++;
			count(arr[index].left);
		}

		if (arr[index].right > 0) {
			count++;
			count(arr[index].right);
		}
	}

	private static void dfs(int index) {
		arr[index].depth = level;
		if (arr[index].left > 0) {
			level++;
			dfs(arr[index].left);
			level--;
		}

		if (arr[index].right > 0) {
			level++;
			dfs(arr[index].right);
			level--;
		}
	}
}

class Node {
	int depth;

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	int here;
	int parent;
	int left;
	int right;

	Node(int here) {
		this.here = here;
	}

	public int getHere() {
		return here;
	}

	public void setHere(int here) {
		this.here = here;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

}
