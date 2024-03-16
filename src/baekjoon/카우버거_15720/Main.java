package baekjoon.카우버거_15720;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static Integer[] burger;
    static Integer[] side;
    static Integer[] drink;

    static int b, c, d;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        burger = new Integer[b];
        side = new Integer[c];
        drink = new Integer[d];

        int total = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < b; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
            total += burger[i];
        }

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < c; i++) {
            side[i] = Integer.parseInt(st.nextToken());
            total += side[i];
        }

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < d; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
            total += drink[i];
        }

        Arrays.sort(burger, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(drink, Collections.reverseOrder());

        int max = Math.max(Math.max(b, c), d);

        for (int i = 0; i < max; i++) {
            int setPrice = getSetPrice(i);
            sum += setPrice;
        }

        System.out.println(total);
        System.out.println(sum);
    }

    private static int getSetPrice(int i) {
        int burgerPrice = 0;
        int sidePrice = 0;
        int drinkPrice = 0;
        if (i < b) burgerPrice = burger[i];
        if (i < c) sidePrice = side[i];
        if (i < d) drinkPrice = drink[i];

        int setPrice = 0;

        boolean isSet = false;

        if (burgerPrice > 0 && sidePrice > 0 && drinkPrice > 0) {
            setPrice += burgerPrice;
            setPrice += sidePrice;
            setPrice += drinkPrice;
            isSet = true;
        } else {
            if(burgerPrice > 0) setPrice += burgerPrice;
            if(sidePrice > 0) setPrice += sidePrice;
            if(drinkPrice > 0) setPrice += drinkPrice;
        }

        if (isSet) setPrice *= 0.9;
        return setPrice;
    }
}
