package baekjoon.OlympiadPizza_15235;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;

    static int[] turns;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        Queue<Person> queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine().trim());

        for (int i = 1; i <= n; i++) {
            queue.offer(new Person(i, Integer.parseInt(st.nextToken())));
        }

        turns = new int[n + 1];

        int turn = 1;

        while (!queue.isEmpty()) {
            Person person = queue.poll();
            person.wantToHave -= 1;
            if (person.wantToHave > 0) {
                queue.offer(person);
            } else {
                turns[person.number] = turn;
            }
            turn++;
        }

        StringBuilder stb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            stb.append(turns[i]).append(' ');
        }

        System.out.println(stb);

    }
}

class Person {
    int number;
    int wantToHave;

    public Person(int number, int wantToHave) {
        this.number = number;
        this.wantToHave = wantToHave;
    }
}
