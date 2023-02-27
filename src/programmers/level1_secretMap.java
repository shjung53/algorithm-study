package programmers;

public class level1_secretMap {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            String[]map1 = new String[n];
            String[]map2 = new String[n];

            for(int i=0; i<n; i++){
                map1[i] = Integer.toBinaryString(arr1[i]);
                map2[i] = Integer.toBinaryString(arr2[i]);
            }

            for(int l=0; l<n; l++){
               while(map1[l].length()<n){
                   map1[l] = "0" + map1[l];
               }

                while(map2[l].length()<n){
                    map2[l] = "0" + map2[l];
                }
            }

            for(int j=0; j<n; j++){
                StringBuilder line= new StringBuilder();
                for(int k=0; k<n; k++){
                    if(map1[j].charAt(k)=='0' && map2[j].charAt(k)=='0'){
                        line.append(" ");
                    }else{
                        line.append("#");
                    }
                }
                answer[j] = line.toString();
            }

            return answer;
        }
    }
}
