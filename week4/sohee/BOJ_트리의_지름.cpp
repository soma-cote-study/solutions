#include <bits/stdc++.h>
using namespace std;
const int MAX = 10004;
int n, a, b, c, maxDist = 0, maxNode;
bool visited[MAX];
vector<pair<int, int>> v[MAX];
void dfs(int x, int dist) {
    visited[x] = 1;
    if (dist > maxDist) {
        maxDist = dist;
        maxNode = x;
    }

    for (auto &ncur: v[x]) {
        int nx = ncur.first;
        int nd = ncur.second;
        if(visited[nx]) continue;
        dfs(nx, dist + nd);
    }
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
    while(n--) {
        cin >> a >> b >> c;
        v[a].push_back({b, c});
        v[b].push_back({a, c});
    }
    
    // 1번에서 가장 먼 노드 찾기
    dfs(1, 0);

    fill(visited, visited + n + 1, false);

    // 가장 먼 노드부터 다시 dfs
    maxDist = 0;
    dfs(maxNode, 0);

    cout << maxDist << "\n";
}
