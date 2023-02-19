package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Sort_10 {
    public int shortest(int[] arr,int n, int distance){
        int ep = -1;
        int count = 1;

        for(int i=1; i<n; i++){
            if(arr[i]-arr[0]>=distance){
                ep = i;
                count++;
                break;
            }
        }


        return 1;
    }

    public int solution(int n, int c, int[] arr){
        int answer =0;
        Arrays.sort(arr);
        int lt = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            if(arr[i]-arr[i-1]<lt){
                lt = arr[i]-arr[i-1];
            }
        }
        int rt = arr[n-1] - arr[0];

        while(lt<=rt){
            int mid = (lt + rt)/2;
            if(shortest(arr, n, mid)>=c){
                answer = mid;
                lt = mid+1;
            }else{
                rt = mid-1;
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        Sort_10 T = new Sort_10();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n,c,arr));
    }

}
