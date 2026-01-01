#include <bits/stdc++.h>
using namespace std;
int n, m, jy, jx, fvisited[1004][1004], jvisited[1004][1004], y, x, ret;
char a[1004][1004];
const int dy[4] = {-1, 0, 1, 0}, dx[4] = {0, 1, 0, -1};
const int INF = 987654321;
queue<pair<int, int>> q;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	fill(&fvisited[0][0], &fvisited[0][0] + 1004*1004, INF);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
			if (a[i][j] == 'F') {
				fvisited[i][j] = 1;
				q.push({i, j});
			}
			else if (a[i][j] == 'J') {
				jy = i; jx = j;
			}
		}
	}
	while (q.size()) {
		tie(y, x) = q.front(); q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if (fvisited[ny][nx] != INF || a[ny][nx] == '#') continue;
			fvisited[ny][nx] = fvisited[y][x] + 1;
			q.push({ny, nx});
		}
	}
	jvisited[jy][jx] = 1;
	q.push({jy, jx});
	while (q.size()) {
		tie(y, x) = q.front(); q.pop();
		if (y == 0 || y == n-1 || x == 0 || x == m-1) {
			ret = jvisited[y][x];
			break;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if (fvisited[ny][nx] <= jvisited[y][x] + 1) continue;
			if (jvisited[ny][nx] || a[ny][nx] == '#') continue;
			jvisited[ny][nx] = jvisited[y][x] + 1;
			q.push({ny, nx});
		}
	}
	if (ret != 0) cout << ret << "\n";
	else cout << "IMPOSSIBLE\n";
}