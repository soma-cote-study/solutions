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

        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> jihoonQ = new LinkedList<>();
        int[][] fire = new int[N][M];
        int[][] jihoon = new int[N][M];
        char[][] map = new char[N][M];

        for(int i = 0; i < N; i++){
            Arrays.fill(fire[i], -1);
            Arrays.fill(jihoon[i], -1);
        }

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                char c = str.charAt(j);
                map[i][j] = c;

                if(c == 'F'){
                    fireQ.offer(new int[]{i, j});
                    fire[i][j] = 0;
                }else if(c == 'J'){
                    jihoonQ.offer(new int[]{i, j});
                    jihoon[i][j] = 0;
                }
            }
        }

        while(!fireQ.isEmpty()){
            int[] current = fireQ.poll();
            int x = current[0];
            int y = current[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == '#') continue;
                if(fire[nx][ny] >= 0) continue;

                fire[nx][ny] = fire[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }

        while(!jihoonQ.isEmpty()){
            int[] current = jihoonQ.poll();
            int x = current[0];
            int y = current[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    System.out.println(jihoon[x][y] + 1);
                    return;
                }

                if(map[nx][ny] == '#' || jihoon[nx][ny] >= 0) continue;
                if(fire[nx][ny] != -1 && fire[nx][ny] <= jihoon[x][y] + 1) continue;

                jihoon[nx][ny] = jihoon[x][y] + 1;
                jihoonQ.offer(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}