#include <bits/stdc++.h>
using namespace std;

typedef pair<int, int> pii;
const int INF = 1e9;
const int MAX = 20004;
vector<pii> adj[MAX];
priority_queue<pii, vector<pii>, greater<pii>> pq;

vector<int> dijkstra(int start) {
    vector<int> dist(MAX, INF);
    dist[start] = 0;
    pq.push({0, start});

    while (pq.size()) {
        auto [cost, u] = pq.top(); pq.pop();

        if (dist[u] != cost) continue;

        for (auto &[v, w] : adj[u]) {
            int new_cost = cost + w;
            if (dist[v] > new_cost) {
                dist[v] = new_cost;
                pq.push({new_cost, v});
            }
        }
    }
    return dist;
}

int main() {
    int n, m, party;
    cin >> n >> m >> party;

    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
    }

    int mx = -1;
    for (int i = 1; i <= n; i++) {
        vector<int> dist = dijkstra(i);
        vector<int> dist2 = dijkstra(party);
        mx = max(dist[party] + dist2[i], mx);
    }
    cout << mx << "\n";
}