import java.util.*;
import java.io.*;

public class Main {
    static boolean[] leak;
    static int n, l, answer;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        leak = new boolean[1001];
        answer = 0;

        st = new StringTokenizer(br.readLine().trim());

        for(int i=0; i<n; i++) {
            int idx = Integer.parseInt(st.nextToken());
            leak[idx] = true;
        }

        for(int i=1; i<1001; i++) {
            if(leak[i]) {
                answer++;
                for(int j = i; j < i + l; j++) {
                    if(j > 1000) continue;
                    leak[j] = false;
                }
            }
        }

        System.out.println(answer);

    }
}
