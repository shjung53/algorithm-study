package pre_edu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LevelLow3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }

        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        System.out.print(arr);
    }
}
