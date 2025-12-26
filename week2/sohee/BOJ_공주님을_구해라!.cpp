#include <bits/stdc++.h>
using namespace std;
struct info {
    int y, x;
    bool g;
};
const int MAX = 104, INF = 1e9;
const int dy[4] = {-1, 0, 1, 0}, dx[4] = {0, 1, 0, -1};
int n, m, t, a[MAX][MAX], dist[MAX][MAX][2], y, x;
bool g;
queue<info> q;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m >> t;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    fill(&dist[0][0][0], &dist[0][0][0] + MAX * MAX * 2, INF);

    dist[0][0][0] = 0;
    q.push({0, 0});

    while(q.size()) {
        auto [y, x, g] = q.front(); q.pop();
        if (dist[y][x][g] > t) continue;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (a[ny][nx] == 1 && g == 0) continue;

            bool ng = g;
            if(a[ny][nx] == 2) ng = 1;

            if(dist[ny][nx][ng] > dist[y][x][g] + 1) {
                dist[ny][nx][ng] = dist[y][x][g] + 1;
                q.push({ny, nx, ng});
            }
        }
    }

    int ans = min(dist[n-1][m-1][0], dist[n-1][m-1][1]);
    if (ans <= t) cout << ans << "\n";
    else cout << "Fail\n";
}
