package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Hash_4 {
    public int solution(String S, String T){
        int answer = 0;
//        우선 T 맵에 다 넣기
        HashMap<Character,Integer> t = new HashMap<>();
        for(char x: T.toCharArray()){
            t.put(x, t.getOrDefault(x,0)+1);
        }
//        S를 T length-1 전 인덱스까지 넣기
        HashMap<Character, Integer> s = new HashMap<>();
        for (int i=0; i<T.length()-1;i++){
            s.put(S.charAt(i),s.getOrDefault(S.charAt(i),0)+1);
        }
//       s에 T length-1 인덱스 넣으면서 아나그램 판별 그후 lt++ 해주면서 진행
        int lt=0;
        for(int rt=T.length()-1; rt<S.length(); rt++){
            s.put(S.charAt(rt),s.getOrDefault(S.charAt(rt),0)+1);
//            equals를 통해 키셋 같은지 확인
            if(s.equals(t)){
                answer++;
            }
            s.put(S.charAt(lt), s.get(S.charAt(lt))-1);
            if(s.get(S.charAt(lt))==0){
                s.remove(S.charAt(lt));
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Hash_4 A = new Hash_4();
        Scanner kb = new Scanner(System.in);
        String S = kb.next();
        String T = kb.next();
        System.out.print(A.solution(S,T));
    }
}
