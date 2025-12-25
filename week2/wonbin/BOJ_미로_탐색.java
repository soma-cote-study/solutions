import java.util.*;
import java.io.*;
public class Main{
    static int R, C, N;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        if(N % 2 == 0){
            fill();
            printMap();
        }else if(N == 1){
            printMap();
        }else {
            bomb();

            if(N % 4 == 1){
                bomb();
            }
            printMap();
        }
    }

    static void fill(){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                map[i][j] = 'O';
            }
        }
    }

    static void bomb(){
        List<int[]> bombs = new ArrayList<>();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'O'){
                    bombs.add(new int[]{i, j});
                }
            }
        }
        fill();

        for(int[] b: bombs){
            int r = b[0];
            int c = b[1];

            map[r][c] = '.';
            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nc >= 0 && nr < R && nc < C){
                    map[nr][nc] = '.';
                }
            }
        }
    }

    static void printMap(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}