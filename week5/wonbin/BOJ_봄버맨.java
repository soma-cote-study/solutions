import java.util.*;
import java.io.*;

public class Main {
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
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        if (N == 1) {
            printMap();
        } else if (N % 2 == 0) {
            fill();
            printMap();
        } else {
            bomb();
            if (N % 4 == 1) {
                bomb();
            }
            printMap();
        }
    }

    static void fill() {
        for (int i = 0; i < R; i++) {
            Arrays.fill(map[i], 'O');
        }
    }

    static void bomb() {
        List<int[]> targetBombs = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') targetBombs.add(new int[]{i, j});
            }
        }

        fill();

        for (int[] b : targetBombs) {
            int r = b[0], c = b[1];
            map[r][c] = '.';
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    map[nr][nc] = '.';
                }
            }
        }
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.print(sb);
    }
}