#include <bits/stdc++.h>
using namespace std;

const int MAX = 1004;
const int dy[4] = {-1, 0, 1, 0};
const int dx[4] = {0, 1, 0, -1};

int n, m, a[MAX][MAX], dist[MAX][MAX];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> m >> n;
    queue<pair<int,int>> q;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
            if (a[i][j] == 1) {
                q.push({i, j});
                dist[i][j] = 0;   // 시작점
            }
            else dist[i][j] = -1; // 아직 안 익음
        }
    }

    while (!q.empty()) {
        auto [y, x] = q.front(); q.pop();
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (a[ny][nx] == 0 && dist[ny][nx] == -1) {
                dist[ny][nx] = dist[y][x] + 1;
                a[ny][nx] = 1;
                q.push({ny, nx});
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (a[i][j] == 0) {
                cout << -1 << "\n";
                return 0;
            }
            ans = max(ans, dist[i][j]);
        }
    }

    cout << ans << "\n";
}