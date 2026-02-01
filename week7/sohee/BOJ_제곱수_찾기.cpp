#include <bits/stdc++.h>
using namespace std;

bool isSquare(long long x) {
    if (x < 0) return false;
    long long r = (long long)(sqrt((long double)x));
    return r * r == x || (r + 1) * (r + 1) == x;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<string> board(N);
    for (int i = 0; i < N; i++) {
        cin >> board[i];
    }

    long long ans = -1;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            for (int dx = -N; dx <= N; dx++) {
                for (int dy = -M; dy <= M; dy++) {
                    if (dx == 0 && dy == 0) continue;

                    long long num = 0;
                    int x = i, y = j;

                    while (x >= 0 && x < N && y >= 0 && y < M) {
                        num = num * 10 + (board[x][y] - '0');
                        if (isSquare(num)) {
                            ans = max(ans, num);
                        }
                        x += dx;
                        y += dy;
                    }
                }
            }
        }
    }

    cout << ans << '\n';
    return 0;
}