#include <bits/stdc++.h>
using namespace std;

int dx[8][3] = {
    {0, 0, 0}, {1, 1, 1}, {2, 2, 2}, // 가로
    {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, // 세로
    {0, 1, 2}, {0, 1, 2}            // 대각선
};
int dy[8][3] = {
    {0, 1, 2}, {0, 1, 2}, {0, 1, 2},
    {0, 0, 0}, {1, 1, 1}, {2, 2, 2},
    {0, 1, 2}, {2, 1, 0}
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int start = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c;
                cin >> c;
                start <<= 1;
                if (c == 'H') start |= 1;
            }
        }

        queue<int> q;
        vector<int> dist(1 << 9, -1);

        q.push(start);
        dist[start] = 0;

        while (!q.empty()) {
            int cur = q.front();
            q.pop();

            for (int k = 0; k < 8; k++) {
                int nxt = cur;
                for (int t = 0; t < 3; t++) {
                    int x = dx[k][t];
                    int y = dy[k][t];
                    int bit = 1 << (8 - (x * 3 + y));
                    nxt ^= bit;
                }

                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    q.push(nxt);
                }
            }
        }

        int allH = (1 << 9) - 1;
        int allT = 0;

        if (dist[allH] == -1 && dist[allT] == -1) {
            cout << -1 << '\n';
        } else if (dist[allH] == -1) {
            cout << dist[allT] << '\n';
        } else if (dist[allT] == -1) {
            cout << dist[allH] << '\n';
        } else {
            cout << min(dist[allH], dist[allT]) << '\n';
        }
    }

    return 0;
}
