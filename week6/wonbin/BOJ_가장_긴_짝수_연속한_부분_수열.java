import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
         int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int R = 0;
        int L = 0;
        int oddCount = 0;
        int maxLength = 0;

        for(R = 0; R < N; R++){
            if(arr[R] % 2 != 0){
                oddCount++;
            }

            while(oddCount > K){
                if(arr[L] % 2 != 0){
                    oddCount--;
                }
                L++;
            }

            int length = (R - L + 1) - oddCount;
            maxLength = Math.max(maxLength, length);
        }

        System.out.println(maxLength);
    }
}