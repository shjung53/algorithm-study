package inflearn;

import java.util.Scanner;

public class Array_12 {
    public int solution(int n,int m, int[][]arr){
        int answer=0;

        for(int mentor=1; mentor<n+1; mentor++){
            for(int mentee=1; mentee<n+1; mentee++){
                int count=0;
                for(int i=0; i<m; i++){
                    int mentorP = -1;
                    int menteeP = -1;
                    for(int j=0; j<n; j++){
                        if(arr[i][j] == mentor){
                            mentorP = j;
                        }else if(arr[i][j] == mentee){
                            menteeP = j;
                        }
                    }
                    if(mentorP < menteeP){
                        count++;
                    }

                }
                if(count == m){
                    answer++;
                }
            }
        }


        return answer;
    }


    public static void main(String[] args) {
        Array_12 T = new Array_12();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(n,m,arr));
    }
}
