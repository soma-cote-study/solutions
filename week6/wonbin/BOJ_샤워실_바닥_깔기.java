import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int tileCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int N = (1 << K);

        map = new int[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int holeX = Integer.parseInt(st.nextToken());
        int holeY = Integer.parseInt(st.nextToken());

        map[holeY][holeX] = -1;

        solve(1, 1, N, holeY, holeX);

        StringBuilder sb = new StringBuilder();
        for (int i = N; i >= 1; i--) {
            for (int j = 1; j <= N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void solve(int r, int c, int size, int hr, int hc) {
        if (size == 1) return;

        int half = size / 2;
        tileCount++;
        int currentTile = tileCount;

        if (!(hr < r + half && hc < c + half)) {
            map[r + half - 1][c + half - 1] = currentTile;
        }

        if (!(hr < r + half && hc >= c + half)) {
            map[r + half - 1][c + half] = currentTile;
        }

        if (!(hr >= r + half && hc < c + half)) {
            map[r + half][c + half - 1] = currentTile;
        }

        if (!(hr >= r + half && hc >= c + half)) {
            map[r + half][c + half] = currentTile;
        }

        if (hr < r + half && hc < c + half) solve(r, c, half, hr, hc); // 원래 구멍 존재
        else solve(r, c, half, r + half - 1, c + half - 1); // 중앙 타일이 구멍 역할

        if (hr < r + half && hc >= c + half) solve(r, c + half, half, hr, hc);
        else solve(r, c + half, half, r + half - 1, c + half);

        if (hr >= r + half && hc < c + half) solve(r + half, c, half, hr, hc);
        else solve(r + half, c, half, r + half, c + half - 1);

        if (hr >= r + half && hc >= c + half) solve(r + half, c + half, half, hr, hc);
        else solve(r + half, c + half, half, r + half, c + half);
    }
}