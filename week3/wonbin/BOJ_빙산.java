import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int year = 0;
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            int count = count();
            if(count == 0){
                System.out.println(0);
                return;
            }else if(count >= 2){
                System.out.println(year);
                return;
            }else if(count == 1){
                melt();
                year++;
            }
        }
    }

    static int count(){
        boolean[][] visited = new boolean[N][M];
        int count = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] > 0 && !visited[i][j]){
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] current = q.poll();
                        int x = current[0];
                        int y = current[1];

                        for(int k = 0; k < 4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if(!visited[nx][ny] && arr[nx][ny] > 0){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    static void melt(){
        int[][] melt = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] > 0){
                    int count = 0;

                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(arr[nx][ny] == 0) count++;
                    }
                    melt[i][j] = count;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(melt[i][j] > 0){
                    arr[i][j] = Math.max(0, arr[i][j] - melt[i][j]);
                }
            }
        }
    }
}