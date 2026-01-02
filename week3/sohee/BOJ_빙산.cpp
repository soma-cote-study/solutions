#include <bits/stdc++.h>
using namespace std;
const int dy[4] = {-1, 0, 1, 0}, dx[4] = {0, 1, 0, -1};
int n, m, a[304][304], visited[304][304], na[304][304], year;
void dfs(int y, int x) {
    visited[y][x] = 1;
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i], nx = x + dx[i];
        if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
        if (visited[ny][nx] || a[ny][nx] == 0) continue;
        dfs(ny, nx);
    }
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
    while (true) {
        memset(visited, 0, sizeof(visited));
        int num = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (visited[y][x] || a[y][x] == 0) continue;
                num++; dfs(y, x);
            }
        }
        if (num == 0) {
            cout << 0 << "\n";
            return 0;
        }
        if (num >= 2) break;
        year++;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d], nx = x + dx[d];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (a[ny][nx] != 0) continue;
                    cnt++;
                }
                if (a[y][x] > 0) na[y][x] = max(0, a[y][x] - cnt);
                else na[y][x] = 0;
            }
        }
        memcpy(a, na, sizeof(a));
    }
    cout << year << "\n";
}
