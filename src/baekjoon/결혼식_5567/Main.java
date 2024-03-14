package baekjoon.결혼식_5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static Person[] persons;

    static boolean[] visited;

    static int n, m, count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        m = Integer.parseInt(br.readLine().trim());

        persons = new Person[n + 1];

        visited = new boolean[n + 1];

        count = 0;

        for(int i=1; i<=n; i++) {
            persons[i] = new Person();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int person = Integer.parseInt(st.nextToken());
            int friend = Integer.parseInt(st.nextToken());

            persons[person].friends.add(friend);
            persons[friend].friends.add(person);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        visited[1] = true;
        int far = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int personN = queue.poll();
                Person person = persons[personN];
                for (int friend : person.friends) {
                    if (visited[friend]) continue;
                    visited[friend] = true;
                    queue.offer(friend);
                }
            }
            far++;
            if (far >= 2) break;
        }

        for (int i = 2; i <= n; i++) {
            if (visited[i]) count++;
        }

        System.out.println(count);
    }
}

class Person {
    ArrayList<Integer> friends = new ArrayList<>();
}
