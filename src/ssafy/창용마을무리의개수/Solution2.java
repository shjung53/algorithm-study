package 창용마을무리의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author shjung
 *
 *         1. 테스트 케이스 개수를 입력받는다. 2. 각 테스트 케이스마다 사람의 수와 관계의 수를 입력받는다.
 *         3. 
 * 
 */

public class Solution2 {
	static int peopleCount;
	static int relationCount;
	static int groupCount;

	static int[] parentList, rankList;

	public static void make() {
		// 배열을 사용하려면 항상 초기화를 먼저 해주어야 합니다.
		// 배열은 항상 인덱스가 0부터 시작
		// 사람의 번호는 1부터 시작하기 때문에 count + 1로 초기화
		parentList = new int[peopleCount + 1];
		rankList = new int[relationCount + 1];

		for (int idx = 0; idx < peopleCount + 1; idx++) {
			parentList[idx] = idx;
		}
	}

	public static void union(int element1, int element2) {
		// 두 그룹을 하나의 그룹으로 묶어주는 작업
		// 두 그룹을 하나의 그룹으로 묶어주려면? ->? 누가 나와야 하는가
		// 부모가 나와야함
		// 각 요소의 부모를 찾아야 함 --> find()

		int e1Parent = find(element1);
		int e2Parent = find(element2);

		// 부모가 서로 동일하다 --> 동일한 그룹이다. 하나의 그룹이다
		if (e1Parent == e2Parent) {
		}

		// 서로 대결을 해야함
		// 누가 랭크가 더 큰지 비교

		if (rankList[e1Parent] > rankList[e2Parent]) {
			// e2의 부모를 e1으로 설정
			rankList[e2Parent] = e1Parent;
		} else {
			rankList[e1Parent] = e2Parent;

			// 랭크가 같은 경우 존재
			if (rankList[e1Parent] == rankList[e2Parent]) {
				rankList[e2Parent]++;
			}
		}

	}

	public static int find(int element) {
		// 부모를 찾다보니까 끝에 도달할건데..
		// 끝에 도달했다라는 의미는? --> 내 위에 부모가 더 이상 없다. --> 내가 부모다.
		if (parentList[element] == element) {
			return element;
		} else {
			// 내가 부모가 아니네?
			// 그러면 다시 부모를 찾으러 떠나야 겠죠?
			// 재귀를 사용하는 이유 --> 경로 압축
			return parentList[element] = find(parentList[element]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine().trim());

		// 테스트 케이스 개수를 입력받는다.
		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			// 2. 각 테스트 케이스마다 사람의 수와 관계의 수를 입력ㅂ다는다.
			peopleCount = Integer.parseInt(st.nextToken());
			relationCount = Integer.parseInt(st.nextToken());
			groupCount = 0;

			// 3. Union-Find를 사용할건데
			// 중요한 내용은 parentList, rankList
			// 나의 부모가 누구인지.. 내가 랭크가 어느정도 되는지..
			make();

			// 4. 관계의 정보를 입력받는다.

			for (int relationIdx = 0; relationIdx < relationCount; relationIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				int firstPeopleNum = Integer.parseInt(st.nextToken());
				int secondPeopleNum = Integer.parseInt(st.nextToken());

				// 두 사람은 서로 잘 알고 있는 사이니까. 하나의 그룹으로 묶어주어야 함
				union(firstPeopleNum, secondPeopleNum);
			}

			// 결국에 그룹이 몇개냐?

			for (int peopleIdx = 1; peopleIdx < peopleCount + 1; peopleIdx++) {
				// 부모가 나 자신이라는 것은 더 이상 대장이 없다.
				if (parentList[peopleIdx] == peopleIdx)
					groupCount++;
			}

			stb.append('#').append(tc).append(' ').append(groupCount).append('\n');
		}
		System.out.println(stb.toString());
	}
}
