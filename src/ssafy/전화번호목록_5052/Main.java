package 전화번호목록_5052;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			n = Integer.parseInt(br.readLine().trim());

			ArrayList<String> number = new ArrayList<String>();

			TrieNode root = new TrieNode();

			for (int i = 1; i <= n; i++) {
				String word = br.readLine().trim();
				number.add(word);
				root.insert(word);
			}

			String answer = "YES";
			boolean isConsistent = true;

			for (int i = 0; i < number.size(); i++) {
				if (root.check(number.get(i))) {
					isConsistent = false;
					break;
				}
			}

			if (isConsistent) {
				stb.append("YES").append('\n');
			} else {
				stb.append("NO").append('\n');
			}
		}
		System.out.println(stb.toString().trim());
	}

}

class TrieNode {
	// 현재 노드가 단어의 마지막이었는지
	boolean isEnd = false;
	// 현재 노드가 가지는 다음 자식 문자 노드들
	Map<Character, TrieNode> childNode = new HashMap<>();

	public TrieNode() {
	}

	public void insert(String word) {
		// 현재 노드
		TrieNode node = this;
		// 단어들의 문자를 트리를 내려가면서 저장한다.
		for (int i = 0; i < word.length(); i++) {
			// 현재 문자
			char c = word.charAt(i);
			// 현재 문자가 현재 노드의 자식에 없으면 넣는다.
			node.childNode.putIfAbsent(c, new TrieNode());
			// 다음 반복문에서의 노드는 자식노드
			node = node.childNode.get(c);

			// 마지막 문자면은 isEnd를 true로
			if (i == word.length() - 1) {
				node.isEnd = true;
				return;
			}
		}
	}

	// 마지막 문자노드가 자식노드가 없으면 접두어가 아니다.
	public boolean check(String word) {
		TrieNode node = this;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			node = node.childNode.get(c);
		}

		if (node.isEnd) {
			if (node.childNode.isEmpty())
				return false;
		}

		return true;
	}
}
