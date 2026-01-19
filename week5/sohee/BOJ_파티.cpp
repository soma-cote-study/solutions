#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX_N = 1004;
const int INF = 1e9;
int n, m, x, a, b, c, mx;
vector<pair<int, int>> adj[MAX_N];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;

vector<int> dijkstra(int start) {
    vector<int> dist(MAX_N, INF);
    dist[start] = 0;
    pq.push({0, start});

    while(pq.size()) {
        int w = pq.top().first;
        int u = pq.top().second;
        pq.pop();

        if (dist[u] != w) continue;

        for (auto &[v, cost] : adj[u]) {
            int new_cost = w + cost;
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
    cin >> n >> m >> x;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        adj[a].push_back({b, c});
    }

    mx = -1;
    for (int i = 1; i <= n; i++) {
        vector<int> dist1 = dijkstra(i);
        vector<int> dist2 = dijkstra(x);
        mx = max(dist1[x] + dist2[i], mx);
    }

    cout << mx << "\n";
}