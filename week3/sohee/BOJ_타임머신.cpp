#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll INF = 1e12;
int n, m, a, b, c;
ll dist[504];
vector<pair<int, int>> v[6004];
bool cycle;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
    fill(dist, dist + 504, INF);
	cin >> n >> m;
    while(m--) {
        cin >> a >> b >> c;
        v[a].push_back({b, c});
    }
    dist[1] = 0;
    for (int i = 0; i < n; i++) {
        for (int here = 1; here <= n; here++) {
            for (auto there : v[here]) {
                int d = there.second;
                int to = there.first;
                if (dist[here] != INF && dist[here] + d < dist[to]) {
                    if(i == n-1) cycle = 1;
                    dist[to] = dist[here] + d;
                }
            }
        }
    }
    if (cycle) cout << -1 << "\n";
    else {
        for (int i = 2; i <= n; i++) {
            cout << (dist[i] == INF ? -1 : dist[i]) << "\n";
        }
    }
}
