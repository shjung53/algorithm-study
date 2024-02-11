import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static StringTokenizer st;

    static int n, a, b;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int round = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }

        System.out.println(round);
    }
}
