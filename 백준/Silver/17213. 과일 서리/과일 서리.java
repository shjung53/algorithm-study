import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n, m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        m = Integer.parseInt(br.readLine().trim());

        long answer;
        long min = 1;
        if(n == 1) {
            answer = 1;
        }else if (n == 2){
            answer = m - n + 1;
        }else{
            min = Math.min(m - n, n - 1);
            answer = 1;
            for(int count = m - 1; count >= m - min; count--) {
                answer *= count;
            }
        }

        int divide = 1;
        for(long num = min; num >= 1; num--) {
            divide *= num;
        }

        System.out.println(answer / divide);


    }
}
