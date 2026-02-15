import java.io.*;

public class Main {
    static int R;
    static int C;
    static String[][] arr;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String[] parts = input.split("");
        N = input.length();

        R = 1;
        C = N;


        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                int r = i;
                int c = N / i;
                if (r <= c) {
                    R = r;
                    C = c;
                }
            }
        }

        arr = new String[R][C];
        count = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                arr[j][i] = parts[count++];
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                String s = arr[i][j];
                sb.append(s);
            }
        }
        System.out.println(sb);
    }
}