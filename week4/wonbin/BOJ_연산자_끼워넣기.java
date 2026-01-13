import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] arr = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        search(1, nums[0]);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void search(int depth, int sum) {
        if (depth == N) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (arr[i] > 0) {
                arr[i]--;

                switch (i) {
                    case 0: search(depth + 1, sum + nums[depth]); break;
                    case 1: search(depth + 1, sum - nums[depth]); break;
                    case 2: search(depth + 1, sum * nums[depth]); break;
                    case 3: search(depth + 1, sum / nums[depth]); break;
                }

                arr[i]++;
            }
        }
    }
}