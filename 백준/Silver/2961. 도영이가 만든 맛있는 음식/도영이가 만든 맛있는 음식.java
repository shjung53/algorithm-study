import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, bitterCount, sourCount, answer;

    static Ingredient[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        sourCount = 1;
        bitterCount = 0;
        answer = Integer.MAX_VALUE;
        arr = new Ingredient[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            arr[i] = new Ingredient(sour, bitter);
        }

        dfs(0);
        System.out.println(answer);
    }


    private static void dfs(int idx) {

        if(idx >= n) {
            if(sourCount == 1 && bitterCount == 0) return;
            int diff = Math.abs(sourCount - bitterCount);
            if(answer > diff) answer = diff;
            return;
        }

        Ingredient now = arr[idx];
        sourCount *= now.sour;
        bitterCount += now.bitter;
        dfs(idx + 1);
        sourCount /= now.sour;
        bitterCount -= now.bitter;
        dfs(idx + 1);
    }
}

class Ingredient {
    int sour;
    int bitter;

    public Ingredient(int sour, int bitter) {
        this.sour = sour;
        this.bitter = bitter;
    }
}
