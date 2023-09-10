package 생일선물_12892;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		Present[] arr = new Present[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Present(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
//		가격 오름차순 정렬
		Arrays.sort(arr);
		
		int left = 0;
		int right = 0;
		
//		초기 포인터 반영
		long sat = arr[0].sat;
		long answer = sat;
		
		while(left < n && right < n) {
//			right++하고 배열 벗어나는지 확인
			right++;
			if(right >= n) continue;
//			안벗어나면 만족도 +
			sat += arr[right].sat;
//			left와 right의 가격차이가 d 밑으로 떨어질때까지 left++와 만족도 빼기 반복
			while(arr[right].price - arr[left].price >= d) {
				sat -= arr[left].sat;
				left++;
			}
			
//			만족도가 역대 최댓값이면 갱신
			if(sat > answer) answer = sat;
			
		}
		
		System.out.println(answer);

	}
}

class Present implements Comparable<Present> {
	int price;
	long sat;

	public Present(int price, long sat) {
		super();
		this.price = price;
		this.sat = sat;
	}

	@Override
	public int compareTo(Present o) {
		// TODO Auto-generated method stub
		return this.price - o.price;
	}
	

}
