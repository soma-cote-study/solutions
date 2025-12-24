import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    static boolean[][] visited;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class coord{
        int x, y, dist;
        coord(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];

        int startX = 0, startY = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }
        bfs(startX, startY);
    }

    private static void bfs(int x, int y){
        Queue<coord> q = new LinkedList<>();
        q.offer(new coord(x, y, 0));
        visited[x][y] = true;

        while(!q.isEmpty()){
            coord current = q.poll();
            dist[current.x][current.y] = current.dist;

            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || arr[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new coord(nx, ny, current.dist + 1));
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    dist[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(dist[i][j]+ " ");
            }
            System.out.println();
        }
    }
}