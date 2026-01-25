import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long total = 0;

        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            if (type == 1) {
                PriorityQueue<Integer> pq = map.computeIfAbsent(name,
                        k -> new PriorityQueue<>(Comparator.reverseOrder()));

                for (int i = 0; i < count; i++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            } else {
                PriorityQueue<Integer> pq = map.get(name);
                if (pq == null) continue;

                for (int i = 0; i < count && !pq.isEmpty(); i++) {
                    total += pq.poll();
                }
            }
        }
        System.out.println(total);
    }
}