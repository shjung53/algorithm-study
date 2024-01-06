package 개미굴_14725;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder stb;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stb = new StringBuilder();
		n = Integer.parseInt(br.readLine().trim());
		Anthill root = new Anthill("root"); // 루트

		for (int i = 0; i < n; i++) {
			// 부모는 루트부터 시작
			Anthill parent = root;
			st = new StringTokenizer(br.readLine().trim());
			int maxLevel = Integer.parseInt(st.nextToken());
			for (int level = 1; level <= maxLevel; level++) {
				// 현재 워드
				String word = st.nextToken();
				Anthill child;
				// 자식에 이미 같은 문자가 있는지 확인
				int index = findSame(word, parent);
				if (index >= 0) {
					// 같은 문자가 이미 있으면 자식에 그 개미굴 할당
					child = parent.children.get(index);
				} else {
					// 워드로 개미굴 만들기
					child = new Anthill(word);
					// 개미굴을 부모 개미굴에 추가하기
					parent.children.add(child);
				}
				// 부모를 자식으로 바꾸고 그 자식으로 이동
				parent = child;
			}
		}

		Anthill now = root;
		dfs(now, "");
		System.out.println(stb.toString());
	}

	private static int findSame(String word, Anthill parent) {
		for (int j = 0; j < parent.children.size(); j++) {
			if (parent.children.get(j).name.equals(word))
				return j;
		}
		return -1;
	}

	private static void dfs(Anthill now, String level) {
		for (int i = 0; i < now.children.size(); i++) {
			if (i == 0) {
				// 같은 레벨은 이름순으로 나열
				Collections.sort(now.children, new Comparator<Anthill>() {
					@Override
					public int compare(Anthill o1, Anthill o2) {
						// TODO Auto-generated method stub
						return o1.name.compareTo(o2.name);
					}
				});
			}
			stb.append(level).append(now.children.get(i).name).append('\n');
			dfs(now.children.get(i), level + "--");
		}
	}
}

class Anthill {
	String name;
	ArrayList<Anthill> children;

	public Anthill(String name) {
		super();
		this.name = name;
		children = new ArrayList<Anthill>();
	}

}
