import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;

    static StringTokenizer st;

    static int n, a, b;
    static Person[] persons;
    static boolean[] visited;

    static boolean isFound;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        persons = new Person[n + 1];
        visited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine().trim());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        isFound = false;

        int tc = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= n; i++) {
            persons[i] = new Person(i, i);
        }

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int parentIdx = Integer.parseInt(st.nextToken());
            int childIdx = Integer.parseInt(st.nextToken());
            persons[childIdx].parent = parentIdx;
            persons[parentIdx].children.add(childIdx);
        }

        int count = 0;
        Queue<Person> queue = new ArrayDeque<>();
        visited[a] = true;
        queue.offer(persons[a]);

        Loop:
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Person now = queue.poll();
                if (now.num == b) {
                    isFound = true;
                    break Loop;
                }
                if (!visited[now.parent]) {
                    visited[now.parent] = true;
                    queue.offer(persons[now.parent]);
                }
                for (int child : now.children) {
                    if (!visited[child]) {
                        visited[child] = true;
                        queue.offer(persons[child]);
                    }
                }
            }
            count++;
        }

        if (!isFound) {
            count = -1;
        }

        System.out.println(count);

    }
}

class Person {
    int num;
    int parent;
    ArrayList<Integer> children = new ArrayList<>();

    public Person(int num, int parentIdx) {
        this.num = num;
        this.parent = parentIdx;
    }
}
