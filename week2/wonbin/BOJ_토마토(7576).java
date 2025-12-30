import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static boolean[][] visited;
    static int M, N;
    static int x, y;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new LinkedList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    x = i;
                    y = j;

                    q.offer(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for(int k = 0; k < size; k++){
                int[] current = q.poll();
                int cx = current[0];
                int cy = current[1];

                for(int i = 0; i < 4; i++){
                    int sx = cx + dx[i];
                    int sy = cy + dy[i];

                    if(sx < 0 || sy < 0 || sx >= N || sy >= M) continue;
                    if(!visited[sx][sy] && arr[sx][sy] == 0){
                        visited[sx][sy] = true;
                        arr[sx][sy] = 1;
                        q.offer(new int[] {sx, sy});
                    }
                }
            }
            if (!q.isEmpty()) {
                count++;
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}