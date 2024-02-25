import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br;

    static int n, min, answer;

    static int[] weights;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        weights = new int[n];
        min = Integer.MAX_VALUE;
        answer = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            weights[i] = Integer.parseInt(br.readLine().trim());
            if(min > weights[i]) min = weights[i];
        }

        Arrays.sort(weights);
        
        for(int i=0; i<n; i++) {
            if(answer < weights[i] * (n - i)) answer = weights[i] * (n - i);
        }

        System.out.println(answer);
    }
}
