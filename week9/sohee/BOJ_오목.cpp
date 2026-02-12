#include <bits/stdc++.h>
using namespace std;

int board[19][19];
int dx[4] = {0, 1, 1, -1};
int dy[4] = {1, 0, 1, 1};

bool inRange(int x, int y) {
    return x >= 0 && x < 19 && y >= 0 && y < 19;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int i = 0; i < 19; i++)
        for (int j = 0; j < 19; j++)
            cin >> board[i][j];

    for (int i = 0; i < 19; i++) {
        for (int j = 0; j < 19; j++) {
            if (board[i][j] == 0) continue;
            int color = board[i][j];

            for (int d = 0; d < 4; d++) {
                int cnt = 1;
                int nx = i + dx[d], ny = j + dy[d];

                while (inRange(nx, ny) && board[nx][ny] == color) {
                    cnt++;
                    nx += dx[d];
                    ny += dy[d];
                }

                int px = i - dx[d], py = j - dy[d];
                if (cnt == 5 && (!inRange(px, py) || board[px][py] != color)) {
                    cout << color << "\n" << i + 1 << " " << j + 1;
                    return 0;
                }
            }
        }
    }

    cout << 0;
}