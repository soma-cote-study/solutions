#include <bits/stdc++.h>
using namespace std;
const int MAX = 104;
const int dy[4] = {-1, 0, 1, 0}, dx[4] = {0, 1, 0, -1}, dh[2] = {-1, 1};
int a[MAX][MAX][MAX], dist[MAX][MAX][MAX];
queue<tuple<int, int, int>> q;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int m, n, _h;
    cin >> m >> n >> _h;
    for (int h = 0; h < _h; h++) {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                cin >> a[h][y][x];
                if (a[h][y][x] == 1) {
                    dist[h][y][x] = 0; q.push({h, y, x});
                }
                else dist[h][y][x] = -1;
            }
        }
    }

    int h, y, x;
    while(q.size()) {
        auto [h, y, x] = q.front(); q.pop();
        for (int d = 0; d < 2; d++) {
            int nh = h + dh[d];
            if (nh < 0 || nh >= _h) continue;
            if (a[nh][y][x] != 0 || dist[nh][y][x] != -1) continue;
            dist[nh][y][x] = dist[h][y][x] + 1; a[nh][y][x] = 1; q.push({nh, y, x});
        }
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (a[h][ny][nx] != 0 || dist[h][ny][nx] != -1) continue;
            dist[h][ny][nx] = dist[h][y][x] + 1; a[h][ny][nx] = 1; q.push({h, ny, nx});
        }
    }

    int ans = 0;
    for (int h = 0; h < _h; h++) {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if(a[h][y][x] == 0) {
                    cout << -1 << "\n";
                    return 0;
                }
                ans = max(ans, dist[h][y][x]);
            }
        }
    }
    cout << ans << "\n";
}