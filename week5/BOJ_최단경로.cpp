#include <bits/stdc++.h>
using namespace std;

typedef pair<int, int> pii;
const int MAX = 20004;
const int INF = 1e9;

int n, m, start, a, b, c;
vector<pii> adj[MAX];
vector<int> dist(MAX, INF);
priority_queue<pii, vector<pii>, greater<pii>> pq;

void dijkstra(int start) {
    dist[start] = 0;
    pq.push({0, start});

    while(pq.size()) {
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
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m >> start;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        adj[a].push_back({b, c});
    }

    dijkstra(start);

    for (int i = 1; i <= n; i++) {
        if (dist[i] == INF) cout << "INF\n";
        else cout << dist[i] << "\n";
    }
}