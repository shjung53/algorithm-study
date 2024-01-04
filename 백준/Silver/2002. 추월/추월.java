import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		int answer = 0;
		HashSet<String> set = new HashSet<>();
		Queue<String> queue = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			String carNumber = br.readLine();
			set.add(carNumber);
			queue.offer(carNumber);
		}
		
		for(int i=0; i<n; i++) {
			String carNumber = br.readLine();
			while(!set.contains(queue.peek())) {
				queue.poll();
			}
			if(queue.peek().equals(carNumber)) {
				queue.poll();
				set.remove(carNumber);
			}else {
				if(set.contains(carNumber)) {
					answer++;
					set.remove(carNumber);
				}
			}
		}
		
		System.out.println(answer);
	}
}
