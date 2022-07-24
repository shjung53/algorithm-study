import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SQ_6 {
    public int solution(int n, int k){
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.offer(i);
        }
        while(!q.isEmpty()){
            for(int i=1; i<k; i++){
                q.offer(q.poll());
            }
            q.poll();
            if(q.size() == 1){
                answer = q.poll();
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        SQ_6 T = new SQ_6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k =kb.nextInt();
        System.out.print(T.solution(n,k));
    }
}
