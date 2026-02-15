import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int T;
    static int N = 6;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());

            if(T == 0) break;
            arr = new int[T];
            for(int i = 0; i < T; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = new int[N];
            search(0, 0);
            System.out.println();
        }
    }

    static void search(int start, int depth){
        if(depth == N){
            StringBuilder sb = new StringBuilder();
            for(int val : result){
                sb.append(val).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        //  0 ~ T까지의 숫자를 전부 탐색해야 한다.
        for(int i = start; i < T; i++){
            result[depth] = arr[i];
            search(i + 1, depth + 1);
        }
    }
}