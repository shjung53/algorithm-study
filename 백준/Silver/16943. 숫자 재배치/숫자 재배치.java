import java.util.*;
import java.io.*;

public class Main {
    static String a, b;
    static int intA,intB, answer;
    static boolean[] visited;
    static int[] cArr;

    static StringTokenizer st;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        a = st.nextToken();
        b = st.nextToken();
        intA = Integer.parseInt(a);
        intB = Integer.parseInt(b);

        visited = new boolean[a.length()];
        cArr = new int[a.length()];
        answer = -1;

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int cIdx){
        if(cIdx >= a.length()) {
            String c = "";
            for(int num: cArr) {
                c+=num;
            }
            int cValue = Integer.parseInt(c);
            if(Integer.toString(cValue).length() < a.length()) return;
            if(cValue < intB){
                if(answer < cValue) answer = cValue;
            }
            return;
        }
        for(int i=0; i<a.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            cArr[cIdx] = Character.getNumericValue(a.charAt(i));
            dfs(cIdx + 1);
            visited[i] = false;
        }

    }
}
