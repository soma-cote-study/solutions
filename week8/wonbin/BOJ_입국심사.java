import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] t = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            t[i] = Long.parseLong(br.readLine());
            if (t[i] > max) max = t[i];
        }

        long l = 0;
        long r = max * m;
        long ans = r;

        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += mid / t[i];
                if (cnt >= m) break;
            }
            if (cnt >= m) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(ans);
    }
}