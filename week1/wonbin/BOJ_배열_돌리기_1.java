import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int width, height;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] answer = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = Math.min(N, M) /2;

        for (int r = 0; r < R; r++) {
            for (int i = 0; i < count; i++) {
                int temp = arr[i][i];

                for (int j = i + 1; j < M - i; j++)
                    arr[i][j - 1] = arr[i][j];

                for (int j = i + 1; j < N - i; j++)
                    arr[j - 1][M - 1 - i] = arr[j][M - 1 - i];

                for (int j = M - 2 - i; j >= i; j--)
                    arr[N - 1 - i][j + 1] = arr[N - 1 - i][j];

                for (int j = N - 2 - i; j >= i; j--)
                    arr[j + 1][i] = arr[j][i];

                arr[i + 1][i] = temp;
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}