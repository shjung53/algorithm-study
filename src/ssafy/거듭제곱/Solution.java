package 거듭제곱;

import java.util.*;
import java.io.*;

class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int t=1; t<=10; t++) {
            int testNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int answer = n;
            int count = 1;
            
            while(count < m) {
                answer *= n;
                count++;
            }
            
            System.out.println(String.format("#%d %d", testNum, answer));
        }
    }
}
