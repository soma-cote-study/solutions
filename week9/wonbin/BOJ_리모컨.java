import java.util.*;
import java.io.*;

class Main {
    static boolean[] remote;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        remote = new boolean[10];

        if(M > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                int k = Integer.parseInt(st.nextToken());
                remote[k] = true;
            }
        }


        int ans = Math.abs(N - 100);

        for(int i = 0; i <= 1000000; i++){
            int len = broken_remote(i);

            if(len > 0){
                int press = len + Math.abs(N - i);
                if(press < ans){
                    ans = press;
                }
            }
        }
        System.out.println(ans);
    }

    static int broken_remote(int n){
        if(n == 0){
            if(remote[n]){
                return 0;
            }else{
                return 1;
            }
        }

        String str = String.valueOf(n);
        int len = str.length();

        for(int i = 0; i < len; i++){
            char c = str.charAt(i);
            int num = c - '0';

            if(remote[num]){
                return 0;
            }
        }
        return len;
    }
}