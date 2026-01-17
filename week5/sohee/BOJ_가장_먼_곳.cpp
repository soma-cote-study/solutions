#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll, int> pli;
const ll INF = 1e18;
const int MAX = 100004;
int n, a, b, c, m, u, v, w;
vector<pli> adj[MAX];
priority_queue<pli, vector<pli>, greater<pli>> pq;

vector<ll> dijkstra(int start) {
    vector<ll> dist(n+1, INF);
    dist[start] = 0;
    pq.push({0, start});
    while(pq.size()) {
        auto [cost, u] = pq.top(); pq.pop();
        if (dist[u] != cost) continue;
        for (auto &[v, w] : adj[u]) {
            ll new_cost = cost + w;
            if (dist[v] > new_cost) {
                dist[v] = new_cost;
                pq.push({new_cost, v});
            }
        }
    }
    return dist;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    cin >> a >> b >> c;

    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }

    vector<ll> da = dijkstra(a);
    vector<ll> db = dijkstra(b);
    vector<ll> dc = dijkstra(c);

    ll bestVal = -1;
    int bestIdx = 0;
    for (int i = 0; i <= n; i++) {
        ll v = min({da[i], db[i], dc[i]});
        if (v == INF) continue;
        if (v > bestVal) {
            bestVal = v;
            bestIdx = i;
        }
    }

    cout << bestIdx << "\n";
}