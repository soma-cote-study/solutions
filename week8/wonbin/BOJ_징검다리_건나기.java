import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            long num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        long left = 0;
        long right = 5000000000L;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            if(check(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static boolean check(long mid){
        boolean[] visited = new boolean[N + 1];
        visited[0] = true;

        for(int i = 0; i < N - 1; i++){
            if(!visited[i]) continue;
            for(int j = i + 1; j < N; j++){
                long power = (long) (j - i) * (1 + Math.abs(list.get(i) - list.get(j)));

                if(power <= mid) {
                    visited[j] = true;
                }
                if(visited[N - 1]) return true;
            }
        }
        return visited[N - 1];
    }
}
