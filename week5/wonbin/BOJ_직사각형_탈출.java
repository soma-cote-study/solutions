import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int H, W, Sx, Sy, Ex, Ey;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenzier(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - map[i - 1][j - 1] + num;
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sx = Integer.parseInt(st.nextToken());
        Sy = Integer.parseInt(st.nextToken());
        Ex = Integer.parseInt(st.nextToken());
        Ey = Integer.parseInt(st.nextToken());

        System.out.println(search());
    }

    static int search(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];

        q,offer(new int[] {Sx, Sy, 0});
        visited[Sx][Sy] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if(x == Ex && y == Ey) return count;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(visited[nx][ny]) continue;

                if(move(nx, ny)){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, nt, count + 1});
                }
            }
        }
        return -1;
    }

    static boolean move(int x, int y){
        int nx = x + H - 1;
        int ny = y + W - 1;

        if(nx > N || ny > M) return false;

        int sum = arr[nx][ny] - arr[x - 1][ny] - arr[nx][y - 1] + arr[x - 1][y - 1];

        if(sum == 0) return true;
        else return false;
    }
}