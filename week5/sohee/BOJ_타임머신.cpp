#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll INF = 1e18;
const int MAX = 504;
int n, m, a, b, c;
ll dist[MAX];
queue<int> q;
vector<pair<int, int>> adj[MAX];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        adj[a].push_back({b, c});
    }

    fill(dist, dist+MAX, INF);
    dist[1] = 0;

    for (int i = 1; i <= n; i++) {
        for (int u = 1; u <= n; u++) {
            for (auto[v, w] : adj[u]) {
                if (dist[u] != INF && dist[v] > dist[u] + w) {
                    if (i == n) q.push(v);
                    dist[v] = dist[u] + w;
                }
            }
        }
    }

    if (q.size()) {
        cout << -1 << "\n";
    } else {
        for (int i = 2; i <= n; i++) {
            cout << (dist[i] == INF ? -1 : dist[i]) << "\n";
        }
    }
}