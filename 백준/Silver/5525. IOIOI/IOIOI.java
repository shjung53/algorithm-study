import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n, s;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        s = Integer.parseInt(br.readLine().trim());
        int answer = 0;

        StringBuilder stb = new StringBuilder("I");
        for(int i=0; i<n; i++) {
            stb.append("OI");
        }
        StringBuilder stb2 = new StringBuilder(br.readLine().trim());
        String pn = stb.toString();

        for(int idx=0; idx <= s - pn.length(); idx++) {
            if(stb2.substring(idx, idx + pn.length()).equals(pn)) answer++;
        }

        System.out.println(answer);
    }
}
