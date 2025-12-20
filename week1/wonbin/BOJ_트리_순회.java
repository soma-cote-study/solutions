import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] left = new int[N + 1];
        int[] right = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            left[a] = b;
            right[a] = c;
        }

        int edges = N - 1;
        int visit = 2 * edges;

        int distance = 0;
        int currentNode = 1;

        while (true) {
            int nextNode = right[currentNode];

            if (nextNode != -1) {
                distance++;
                currentNode = nextNode;
            } else {
                break;
            }
        }

        System.out.println(visit - distance);
    }
}