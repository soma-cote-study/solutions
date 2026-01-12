import java.io.*;
import java.util.*;

public class Main {
    static char[] arr;
    static char[] result;
    static boolean[] visited;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();
            N = input.length();

            arr = input.toCharArray();
            result = new char[N];
            visited = new boolean[N];

            Arrays.sort(arr);

            search(0);
        }
        System.out.print(sb);
    }

    static void search(int depth) {
        if (depth == N) {
            sb.append(result).append('\n');
            return;
        }

        char prev = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (arr[i] == prev) continue;


            visited[i] = true;
            result[depth] = arr[i];
            prev = arr[i];

            search(depth + 1);
            visited[i] = false;
        }
    }
}