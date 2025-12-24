import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] block = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            block[i] = Integer.parseInt(st.nextToken());
        }
        int Rain = 0;



        for(int i = 1; i < W - 1; i++){
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++){
                left = Math.max(left, block[j]);
            }

            for(int j = i + 1; j < W; j++){
                right = Math.max(right, block[j]);
            }

            int bound = Math.min(left, right);

            if(bound > block[i]){
                Rain += bound - block[i];
            }
        }

        System.out.println(Rain);
    }
}