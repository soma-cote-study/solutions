import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int m = sc.nextInt();
            System.out.println((m + 1) / 2);

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int count = 0;
            for (int i = 0; i < m; i++) {
                int val = sc.nextInt();

                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(val);
                } else {
                    minHeap.offer(val);
                }

                if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    int maxTop = maxHeap.poll();
                    int minTop = minHeap.poll();
                    maxHeap.offer(minTop);
                    minHeap.offer(maxTop);
                }

                if (i % 2 == 0) {
                    System.out.print(maxHeap.peek() + " ");
                    count++;
                    if (count % 10 == 0) {
                        System.out.println();
                    }
                }
            }
            if (count % 10 != 0) {
                System.out.println();
            }
        }
    }
}