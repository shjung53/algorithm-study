import java.util.Scanner;

public class String_6 {
    public String solution(String str){
        String answer="";
        for(int i = 0; i<str.length(); i++){
//            System.out.print(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i)) == i){
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String_6 T = new String_6();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));

    }
}
