#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const ll INF = 1e18;
const int MAX = 1004;
ll dist[MAX];
int t, n, m, w, a, b, c;
vector<pair<int, int>> adj[MAX];
bool cycle;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> t;
    while (t--) {
        cycle = false;
        for (int i = 0; i < MAX; i++) adj[i].clear();
        fill(dist, dist+MAX, 0); // 모든 정점을 시작점으로

        cin >> n >> m >> w;
        for (int i = 0; i < m; i++) {
            cin >> a >> b >> c;
            adj[a].push_back({b, c});
            adj[b].push_back({a, c});
        }
        for (int i = 0; i < w; i++) {
            cin >> a >> b >> c;
            adj[a].push_back({b, -c});
        }

        for (int i = 1; i <= n; i++) {
            for (int u = 1; u <= n; u++) {
                for (auto [v, w] : adj[u]) { 
                    if (dist[v] > dist[u] + w) {
                        if (i == n) cycle = true;
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        if (cycle) cout << "YES\n";
        else cout << "NO\n";
    }
}