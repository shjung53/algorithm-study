import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static HashMap<String, Person> family;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 가계도에 왕 추가
		family = new HashMap<String, Person>();
		String ancestorName = br.readLine().trim();
		Person ancestor = new Person();
		ancestor.fleshAndBlood = true;
		family.put(ancestorName, ancestor);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			String childName = st.nextToken();
			String fatherName = st.nextToken();
			String motherName = st.nextToken();

			// 아이의 엄마 아빠 이름 설정
			Person child = family.getOrDefault(childName, new Person());
			child.father = fatherName;
			child.mother = motherName;

			// 엄마 아빠에게 아이 데이터 추가
			Person father = family.getOrDefault(fatherName, new Person()); // 없으면 새로 만든다.
			Person mother = family.getOrDefault(motherName, new Person());

			// 자식 추가
			father.children.add(childName);
			mother.children.add(childName);

			family.put(fatherName, father);
			family.put(motherName, mother);

			family.put(childName, child);
		}

		Queue<String> queue = new ArrayDeque<>();

		queue.offer(ancestorName);

		while (!queue.isEmpty()) {
			String personName = queue.poll();
			Person person = family.get(personName);
			boolean fleshAndBlood = false;

			if (ancestorName.equals(personName)) {
				person.blood = 1.0;
				fleshAndBlood = true;
			} else {
				Person father = family.get(person.father);
				Person mother = family.get(person.mother);

				double fatherBlood;
				double motherBlood;

				if (!father.fleshAndBlood) {
					fatherBlood = 0.0; // 아버지가 혈족이 아니면 0처리
				} else {
					fatherBlood = father.blood;
					fleshAndBlood = true;
				}
				if (!mother.fleshAndBlood) {
					motherBlood = 0.0;
				} else {
					motherBlood = mother.blood;
					fleshAndBlood = true;
				}

				person.fleshAndBlood = true;
				person.blood = (fatherBlood + motherBlood) / 2; // 피 계산
			}

			for (String childName : person.children) {
				queue.offer(childName); // 자식을 모두 넣는다.
			}
		}

		String nextKing = br.readLine().trim(); // 첫번째 왕위 계승자 후보

		for (int i = 0; i < m - 1; i++) {
			String candidateName = br.readLine().trim();

			if (family.get(candidateName) == null)
				continue;

			if (family.get(nextKing) == null) // 후보자가 들어 왔는데 기존 후보자가 혈족이 아니면 당연히 비켜준다. // 다음 코드에서 NPE를 막기 위해
			{
				nextKing = candidateName;
				continue;
			}

			if (family.get(nextKing).blood < family.get(candidateName).blood) // 후보자 둘다 혈족이면 피 비교하기
				nextKing = candidateName;
		}

		System.out.println(nextKing);

	}
}

class Person {
	boolean fleshAndBlood = false;
	double blood = 0.0;
	String father, mother;
	ArrayList<String> children = new ArrayList<String>();
}
