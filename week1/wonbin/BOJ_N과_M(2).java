import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        result = new int[M];
        search(1, 0);
        System.out.println(sb);
    }

    private static void search(int start, int depth){
        if(depth == M){
            for(int num : result){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++){
            result[depth] = i;
            search(i + 1, depth + 1);
        }
    }
}

