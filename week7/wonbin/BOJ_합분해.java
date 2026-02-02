
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= K; i++){
            for(int j = 0; j <= N; j++){
                int sum = 0;
                for (int L = 0; L <= j; L++) {
                    sum += dp[i-1][j-L];
                    sum %= 1000000000;
                }
                dp[i][j] = sum;
            }
        }
        System.out.println(dp[K][N]);
    }
}