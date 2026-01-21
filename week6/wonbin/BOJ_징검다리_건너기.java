import java.util.*;
import java.io.*;

class Main {
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][2];
        int[][] arr = new int[N + 1][2];

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[1][0] = 0;

        for(int i = 2; i <= N; i++){
            dp[i][0] = dp[i-1][0] + arr[i-1][0];

            if(i >= 3){
                dp[i][0] = Math.min(dp[i][0], dp[i-2][0] + arr[i-2][1]);
            }

            dp[i][1] = dp[i-1][1] + arr[i-1][0];

            if(i >= 3){
                dp[i][1] = Math.min(dp[i][1], dp[i-2][1] + arr[i-2][1]);
            }

            if(i >= 4){
                dp[i][1] = Math.min(dp[i][1], dp[i-3][0] + K);
            }
        }
        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}