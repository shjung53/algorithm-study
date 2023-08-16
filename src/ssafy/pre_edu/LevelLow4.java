package pre_edu;

import java.util.Scanner;

public class LevelLow4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i < n + 1; i++) {
            int max = 0;
            for (int j = 0; j < 10; j++) {
                int num = sc.nextInt();
                if (num > max) {
                    max = num;
                }
                if (j == 9) {
                    System.out.println("#" + i + " " + max);
                }
            }
        }
    }
}
