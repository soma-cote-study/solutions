import java.util.*;
import java.io.*;

class Main {
    static int r, c;
    static int N;
    static int size;
    static int result = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2, N);

        dfs(0, 0, size);
        System.out.println(result);
    }

    static void dfs(int row, int col, int size){
        if(size == 1){
            result = count;
            return;
        }

        int half = size / 2;

        if(r < row + half && c < col + half){
            dfs(row, col, half);
        }else if(r < row + half && c >= col + half){
            count += half * half;
            dfs(row, col + half, half);
        }else if(r >= row + half && c < col + half){
            count += 2 * half * half;
            dfs(row + half, col, half);
        }else if(r >= row + half && c >= col + half){
            count += 3 * half * half;
            dfs(row + half, col + half, half);
        }
    }
}