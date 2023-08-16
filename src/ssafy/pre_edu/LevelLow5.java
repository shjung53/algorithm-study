package pre_edu;

import java.util.Scanner;

public class LevelLow5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                int num = sc.nextInt();
                if (num % 2 != 0) {
                    sum += num;
                }
                if (j == 9) {
                    System.out.println("#" + i + " " + sum);
                }
            }
        }
    }
}
