#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;
const int INF = 1e9;
int n, m, s, u, v, w;
vector<pii> adj[20004];
vector<int> dist(20004, INF);
priority_queue<pii, vector<pii>, greater<pii>> pq;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m >> s;
	while(m--){
		cin >> u >> v >> w;
		adj[u].push_back({v, w});
	}

	dist[s] = 0;
	pq.push({0, s});

	while(pq.size()){
		int c = pq.top().first;
		int x = pq.top().second;
		pq.pop();

		if(dist[x] != c) continue;

		for (auto &[nx, cost] : adj[x]){
			int nc = c + cost;
			if(nc < dist[nx]) {
				dist[nx] = nc;
				pq.push({nc, nx});
			}
		}
	}

	for (int i = 1; i <= n; i++){
		if(dist[i] == INF) cout << "INF\n";
		else cout << dist[i] << "\n";
	}
}
