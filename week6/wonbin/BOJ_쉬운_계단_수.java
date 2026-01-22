import java.util.*;
import java.io.*;

class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        for(int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                if(j == 0){
                    dp[i][0] = dp[i - 1][1];
                }else if(j == 9){
                    dp[i][9] = dp[i - 1][8];
                }else{
                    dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1])  % INF;
                }
            }
        }
        long answer = 0;
        for(int j = 0; j <= 9; j++){
            answer = (answer + dp[N][j]) % INF;
        }
        System.out.println(answer);
    }
}
