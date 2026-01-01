#include <bits/stdc++.h>
using namespace std;
const int dy[4] = {-1, 0, 1, 0}, dx[4] = {0, 1, 0, -1};
int n, m, a[1004][1004], h, w, sy, sx, fy, fx, visited[1004][1004], y, x, d;
bool wall(int y, int x, int dir) {
    // 위로 이동
    if (dir == 0) {
        int ny = y; // 새로 닿는 윗줄
        for (int j = x; j < x + w; j++) {
            if (a[ny][j] == 1) return true;
        }
    }
    // 오른쪽 이동
    else if (dir == 1) {
        int nx = x + w - 1; // 새로 닿는 오른쪽 열
        for (int i = y; i < y + h; i++) {
            if (a[i][nx] == 1) return true;
        }
    }
    // 아래로 이동
    else if (dir == 2) {
        int ny = y + h - 1; // 새로 닿는 아랫줄
        for (int j = x; j < x + w; j++) {
            if (a[ny][j] == 1) return true;
        }
    }
    // 왼쪽 이동
    else if (dir == 3) {
        int nx = x; // 새로 닿는 왼쪽 열
        for (int i = y; i < y + h; i++) {
            if (a[i][nx] == 1) return true;
        }
    }
    return false;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }
    cin >> h >> w >> sy >> sx >> fy >> fx;
    sy--; sx--; fy--; fx--;

    queue<tuple<int, int, int>> q;
    q.push({sy, sx, 0});
    visited[sy][sx] = 1;

    while(q.size()) {
        auto [y, x, d] = q.front(); q.pop();

        if (y == fy && x == fx) {
            cout << d << "\n"; return 0;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 0 || ny + h > n || nx < 0 || nx + w > m) continue;
            if (visited[ny][nx] || wall(ny, nx, i)) continue;
            visited[ny][nx] = 1; q.push({ny, nx, d+1});
        }
    }

    cout << -1 << "\n";
}
