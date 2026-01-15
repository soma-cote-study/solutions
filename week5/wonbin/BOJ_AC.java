import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                appendResult(deque, isReversed, sb);
            }
        }
        System.out.print(sb);
    }

    private static void appendResult(ArrayDeque<Integer> deque, boolean isReversed, StringBuilder sb) {
        sb.append("[");
        while (!deque.isEmpty()) {
            sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
            if (!deque.isEmpty()) sb.append(",");
        }
        sb.append("]\n");
    }
}