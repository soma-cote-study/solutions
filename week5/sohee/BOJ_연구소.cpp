#include <bits/stdc++.h>
using namespace std;
const int MAX = 10;
const int dy[4] = {-1, 0, 1, 0}, dx[4] = {0, 1, 0, -1};
int n, m, a[MAX][MAX], ans, visited[MAX][MAX];
vector<pair<int, int>> zero, virus;

void dfs(int y, int x) {
    visited[y][x] = 1;
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
        if (visited[ny][nx] || a[ny][nx] == 1) continue;
        dfs(ny, nx);
    }
}

int solve() {
    fill(&visited[0][0], &visited[0][0] + MAX*MAX, 0);
    for (pair<int, int> v : virus) {
        dfs(v.first, v.second);
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (a[i][j] == 0 && !visited[i][j]) cnt++;
        }
    }
    
    return cnt;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
            if (a[i][j] == 0) zero.push_back({i, j});
            else if (a[i][j] == 2) virus.push_back({i, j});
        }
    }

    for (int i = 0; i < zero.size(); i++) {
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < j; k++) {
                a[zero[i].first][zero[i].second] = 1;
                a[zero[j].first][zero[j].second] = 1;
                a[zero[k].first][zero[k].second] = 1;
                ans = max(ans, solve());
                a[zero[i].first][zero[i].second] = 0;
                a[zero[j].first][zero[j].second] = 0;
                a[zero[k].first][zero[k].second] = 0;
            }
        }
    }

    cout << ans << "\n";
}