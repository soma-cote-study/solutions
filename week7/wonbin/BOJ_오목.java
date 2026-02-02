import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[19][19];
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (map[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        if (check(i, j, d, map[i][j])) {
                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean check(int x, int y, int dir, int color) {
        int nx = x - dx[dir];
        int ny = y - dy[dir];

        if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
            if (map[nx][ny] == color) return false;
        }

        int count = 1;

        nx = x;
        ny = y;
        for (int i = 0; i < 4; i++) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) break;
            if (map[nx][ny] != color) break;

            count++;
        }

        if (count != 5) return false;

        nx += dx[dir];
        ny += dy[dir];

        if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
            if (map[nx][ny] == color) return false;
        }

        return true;
    }
}