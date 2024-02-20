package baekjoon.생태학_4358;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static String species;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        HashMap<String, Double> map = new HashMap<>();

        while(total < 10002) {
            species = br.readLine().trim();
            if(species.length() == 0) break;
            map.put(species, map.getOrDefault(species, 0.0) + 1);
            total++;
        }

        ArrayList<String> arr = new ArrayList<>();

        for(String name: map.keySet()) {
            String rate = String.format("%.4f", map.get(name) / total * 100);
            arr.add(name + " " + rate);
        }

        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });


        for(String content: arr) {
            System.out.println(content.trim());
        }

    }
}
