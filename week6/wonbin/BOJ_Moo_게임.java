import java.util.*;
import java.io.*;

class Main {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long length = 3;
        int k = 0;

        while(length < N){
            k++;

            length = length * 2 + (k + 3);
        }

        search(N, k, length);
    }

    static void search(long n, long k, long length){
        long prev = (length - (k + 3)) / 2;

        if(n <= prev){
            search(n, k - 1, prev);
        }

        else if(n > prev + (k + 3)){

            search(n - (prev + (k + 3)), k - 1, prev);
        }else{
            if(n - prev == 1){
                System.out.println("m");
            }else{
                System.out.println("o");
            }
            return;
        }
    }
}