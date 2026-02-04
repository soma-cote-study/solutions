import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long num;
        int count;

        public Node(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    static long A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(A, 1));

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.num == B) {
                System.out.println(current.count);
                return;
            }

            long next1 = current.num * 2;
            if (next1 <= B) {
                q.offer(new Node(next1, current.count + 1));
            }
            long next2 = (current.num * 10) + 1;
            if (next2 <= B) {
                q.offer(new Node(next2, current.count + 1));
            }
        }
        System.out.println("-1");
    }
}