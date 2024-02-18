import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    static int n;

    static String[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine().trim());
        }

        arr = new String[set.size()];

        arr = set.toArray(arr);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
