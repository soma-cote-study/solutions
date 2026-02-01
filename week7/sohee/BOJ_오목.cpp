#include <bits/stdc++.h>
using namespace std;

int board[19][19];
int dx[4] = {0, 1, 1, -1};   // 오른쪽, 아래, 오른쪽아래, 오른쪽위
int dy[4] = {1, 0, 1, 1};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int i = 0; i < 19; i++) {
        for (int j = 0; j < 19; j++) {
            cin >> board[i][j];
        }
    }

    for (int i = 0; i < 19; i++) {
        for (int j = 0; j < 19; j++) {
            if (board[i][j] == 0) continue;

            int color = board[i][j];

            for (int d = 0; d < 4; d++) {
                int cnt = 1;
                int nx = i;
                int ny = j;

                while (true) {
                    nx += dx[d];
                    ny += dy[d];
                    if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) break;
                    if (board[nx][ny] != color) break;
                    cnt++;
                }

                if (cnt == 5) {
                    int px = i - dx[d];
                    int py = j - dy[d];

                    if (px >= 0 && px < 19 && py >= 0 && py < 19) {
                        if (board[px][py] == color) continue;
                    }

                    cout << color << '\n';
                    cout << i + 1 << ' ' << j + 1 << '\n';
                    return 0;
                }
            }
        }
    }

    cout << 0 << '\n';
    return 0;
}
