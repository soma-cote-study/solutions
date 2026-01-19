#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 20004;
const int INF = 1e9;
int n, m, k, u, v, w;
vector<int> dist(MAX_N, INF);
vector<pair<int, int>> adj[MAX_N];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

void dijkstra(int start) {
    dist[start] = 0;
    pq.push({0, start});

    while(pq.size()) {
        auto [cost, x] = pq.top();
        pq.pop();

        if (dist[x] != cost) continue;

        for (auto &[nx, c] : adj[x]) {
            int new_cost = cost + c;
            if (dist[nx] > new_cost) {
                dist[nx] = new_cost;
                pq.push({new_cost, nx});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m >> k;
    for (int i = 0; i < m; i++) {
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
    }

    dijkstra(k);

    for (int i = 1; i <= n; i++) {
        if (dist[i] == INF) cout << "INF\n";
        else cout << dist[i] << "\n";
    }
}