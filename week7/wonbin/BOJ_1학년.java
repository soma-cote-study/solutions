import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N + 1][21];
        dp[0][arr[0]] = 1;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if(dp[i - 1][j] > 0){
                    int current = arr[i];

                    if (j + current <= 20) dp[i][j + current] += dp[i-1][j];
                    if (j - current >= 0) dp[i][j - current] += dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N - 2][arr[N - 1]]);
    }
}