package inflearn.first;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Patient{
    int id;
    int priority;
    public Patient(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

public class SQ_8 {
    public int solution(int n, int m, int[] arr){
        int answer =1;
        Queue<Patient> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.add(new Patient(i, arr[i]));
        }
        while(!q.isEmpty()){
            Patient p = q.poll();
            for(Patient x: q){
                if(x.priority>p.priority){
                    q.add(p);
                    p=null;
                    break;
                }
            }
            if(p != null){
                if(p.id==m) return answer;
                else answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SQ_8 T = new SQ_8();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.print(T.solution(n,m,arr));
    }
}
