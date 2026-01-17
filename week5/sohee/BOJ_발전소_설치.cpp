#include <bits/stdc++.h>
using namespace std;

typedef pair<int, double> pid;
typedef pair<double, int> pdi;
typedef pair<int, int> pii;
const double INF = 1e18;
const int MAX = 1004;

int n, m, start, a, b;
double limit;
vector<pid> adj[MAX];
vector<double> dist(MAX, INF);
priority_queue<pdi, vector<pdi>, greater<pdi>> pq;

void dijkstra(int start) {
    dist[start] = 0.0;
    pq.push({dist[start], start});

    while(pq.size()) {
        auto [cost, u] = pq.top(); pq.pop();

        if (dist[u] != cost) continue;

        for (auto &[v, w] : adj[u]) {
            double new_cost = cost + w;
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

    cin >> n >> m >> limit;
    vector<pii> pos(n+1);
    for (int i = 1; i <= n; i++) {
        cin >> pos[i].first >> pos[i].second;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = i+1; j <= n; j++) {
            double dy = pos[i].first - pos[j].first;
            double dx = pos[i].second - pos[j].second;
            double d = sqrt(dy*dy + dx*dx);
            if (d <= limit) {
                adj[i].push_back({j, d});
                adj[j].push_back({i, d});
            }
        }
    }

    for (int i = 1; i <= m; i++) {
        cin >> a >> b;
        adj[a].push_back({b, 0.0});
        adj[b].push_back({a, 0.0});
    }

    start = 1;
    dijkstra(start);

    cout << (long long) (dist[n] * 1000 )<< "\n";
}