import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 1][M + 1];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.offer(new int[]{1, 1, 0});
        visited[1][1] = true;

        int answer = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] current = q.poll();

            int cx = current[0];
            int cy = current[1];
            int time = current[2];

            if(time > T) continue;
            if(cx == N && cy == M){
                answer = Math.min(answer, time);
                break;
            }

            if(arr[cx][cy] == 2){
                int manhattan = time + Math.abs(N - cx) + Math.abs(M - cy);
                answer = Math.min(answer, manhattan);
            }

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;

                if(!visited[nx][ny]){
                    if(arr[nx][ny] != 1){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, time + 1});
                    }
                }
            }

        }

        if(answer <= T) System.out.println(answer);
        else System.out.println("Fail");
    }
}