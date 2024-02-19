import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int n, m, count, minCount, answer, depth;

    static Person[] persons;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        persons = new Person[n + 1];

        for (int i = 1; i <= n; i++) {
            persons[i] = new Person();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            persons[from].friends.add(to);
            persons[to].friends.add(from);
        }

        minCount = Integer.MAX_VALUE;
        answer = 0;

        for (int i = 1; i <= n; i++) {
            count = 0;
            depth = 0;
            visited = new boolean[n + 1];
            bfs(i);
            if (minCount > count) {
                minCount = count;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int number) {
        Queue<Person> queue = new ArrayDeque<>();
        visited[number] = true;
        queue.offer(persons[number]);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Person person = queue.poll();
                count += depth;
                for (int friend : person.friends) {
                    if (visited[friend]) continue;
                    visited[friend] = true;
                    queue.offer(persons[friend]);
                }
            }
            depth++;
        }
    }
}

class Person {
    ArrayList<Integer> friends = new ArrayList<>();

    public Person() {
    }
}
