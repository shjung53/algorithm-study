package 가장가까운공통조상_3584;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n;
	static Node[] nodes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testCase; tc++) {
			n = Integer.parseInt(br.readLine().trim());

			// 1부터 n까지의 노드
			nodes = new Node[n + 1];

			// 노드 초기화
			for (int i = 1; i <= n; i++) {
				nodes[i] = new Node(i, i); // 자기 자신이 부모면 루트
			}

			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				// 부모에 할당
				nodes[child].parent = parent;

				// 자식에 할당
				nodes[parent].children.add(nodes[child]);
			}

			int root = 0;

			for (int i = 1; i <= n; i++) {
				if (nodes[i].parent == nodes[i].here)
					root = i; // 자기 자신이 부모면 루트 노드
			}

			setDepth(root, 0); // 루트 노드부터 depth 설정하기

			// 공통조상을 구할 두 노드 a, b
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// a와 b의 공통 조상을 찾을 준비
			int pA = nodes[a].here;
			int pB = nodes[b].here;

			// 공통 조상을 확인하기 위해 우선 뎁스를 맞춘다.
			while (nodes[pA].depth > nodes[pB].depth) {
				pA = nodes[pA].parent;
			}

			while (nodes[pA].depth < nodes[pB].depth) {
				pB = nodes[pB].parent;
			}

			// 부모로 가면서 부모가 같은지 확인
			while (nodes[pA].here != nodes[pB].here) {
				pA = nodes[pA].parent;
				pB = nodes[pB].parent;
			}

			stb.append(pA).append('\n');
		}
		System.out.println(stb.toString());
	}

	private static void setDepth(int nodeIdx, int depth) {
		nodes[nodeIdx].depth = depth; // 뎁스 할당

		// 자식들 뎁스 할당하러 출발
		for (int i = 0; i < nodes[nodeIdx].children.size(); i++) {
			setDepth(nodes[nodeIdx].children.get(i).here, depth + 1);
		}
	}
}

class Node {
	int depth;
	int here;
	int parent;
	ArrayList<Node> children;

	public Node(int here, int parent) {
		super();
		this.here = here;
		this.parent = parent;
		children = new ArrayList<Node>();
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

}
